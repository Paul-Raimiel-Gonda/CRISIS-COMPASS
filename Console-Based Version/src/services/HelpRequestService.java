package services;

import database.DatabaseConnection;
import models.HelpRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HelpRequestService {

    private final Connection connection;

    //HANDLES ALL OPERATIONS FOR DISASTER REQUESTS
    public HelpRequestService() {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing database connection", e);
        }
    }
    public void createHelpRequest(HelpRequest request) {
        String query = "INSERT INTO HelpRequests (user_id, disaster_type, request_details, status) " +
                "VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, request.getUserId());
            stmt.setString(2, request.getDisasterType());
            stmt.setString(3, request.getDescription());
            stmt.setString(4, request.getStatus().name());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating help request: " + e.getMessage());
        }
    }

    /**
     * Fetches ongoing help requests.
     */
    public List<HelpRequest> getOngoingHelpRequests() {
        List<HelpRequest> requests = new ArrayList<>();
        String query = "SELECT hr.request_id, u.username, hr.disaster_type, hr.request_details, hr.status " +
                "FROM HelpRequests hr " +
                "JOIN Users u ON hr.user_id = u.user_id " +
                "WHERE hr.status != 'Resolved'";

        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                requests.add(new HelpRequest(
                        rs.getInt("request_id"),
                        rs.getString("username"),
                        rs.getString("disaster_type"),
                        rs.getString("request_details"),
                        HelpRequest.Status.valueOf(rs.getString("status").toUpperCase())
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching ongoing help requests: " + e.getMessage());
        }
        return requests;
    }

    /**
     * Fetches all help requests for a specific user.
     */
    public List<HelpRequest> getHelpRequestsByUserId(int userId) {
        List<HelpRequest> requests = new ArrayList<>();
        String query = "SELECT * FROM HelpRequests WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                requests.add(new HelpRequest(
                        rs.getInt("request_id"),
                        rs.getInt("user_id"),
                        rs.getString("disaster_type"),
                        rs.getString("request_details"),
                        HelpRequest.Status.valueOf(rs.getString("status").toUpperCase())
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching help requests for user ID: " + e.getMessage());
        }
        return requests;
    }

    /**
     * Updates a help request's details.
     */
    public boolean updateHelpRequestDetails(int requestId, String newDetails, int userId) {
        String query = "UPDATE HelpRequests SET request_details = ? WHERE request_id = ? AND user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newDetails);
            stmt.setInt(2, requestId);
            stmt.setInt(3, userId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating help request details: " + e.getMessage());
        }
        return false;
    }

    /**
     * Updates a help request's status.
     */
    public boolean updateHelpRequestStatus(int requestId, HelpRequest.Status status, int userId) {
        String query = "UPDATE HelpRequests SET status = ? WHERE request_id = ? AND user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status.name());
            stmt.setInt(2, requestId);
            stmt.setInt(3, userId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error updating help request status: " + e.getMessage());
        }
        return false;
    }
}
