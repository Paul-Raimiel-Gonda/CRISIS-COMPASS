package services;

import database.DatabaseConnection;
import models.HelpRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for managing help requests.
 */
public class HelpRequestService {

    private final Connection connection;

    public HelpRequestService() {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Error while getting connection in HelpRequestService: " + e.getMessage());
        }
        this.connection = conn;
    }

    /**
     * Fetches all help requests for a user.
     *
     * @param username The username of the requester.
     * @return List of help requests.
     * @throws SQLException If a database error occurs.
     */
    public List<HelpRequest> getHelpRequestsByUsername(String username) {
        String query = "SELECT * FROM HelpRequests WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            List<HelpRequest> requests = new ArrayList<>();
            while (rs.next()) {
                HelpRequest request = new HelpRequest(
                        rs.getInt("requestId"),
                        rs.getString("username"),
                        rs.getString("description"),
                        HelpRequest.Status.valueOf(rs.getString("status").toUpperCase())
                );
                requests.add(request);
            }
            return requests;
        } catch (SQLException e) {
            System.err.println("Error fetching help requests for user: " + username);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Creates a new help request.
     *
     * @param request The HelpRequest object.
     * @throws SQLException If a database error occurs.
     */
    public void createHelpRequest(HelpRequest request) {
        String query = "INSERT INTO HelpRequests (username, description, status, timestamp) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, request.getUsername());
            stmt.setString(2, request.getDescription());
            stmt.setString(3, request.getStatus().toString());
            stmt.setTimestamp(4, Timestamp.valueOf(request.getTimestamp()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error creating help request: " + e.getMessage());
        }
    }

    /**
     * Updates the status of a help request.
     *
     * @param requestId The ID of the help request.
     * @param status    The new status.
     * @throws SQLException If a database error occurs.
     */
    public void updateHelpRequestStatus(int requestId, HelpRequest.Status status) {
        String query = "UPDATE HelpRequests SET status = ? WHERE requestId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status.toString());
            stmt.setInt(2, requestId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating help request status: " + e.getMessage());
        }
    }
}
