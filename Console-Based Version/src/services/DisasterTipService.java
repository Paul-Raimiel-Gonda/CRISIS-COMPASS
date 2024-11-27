package services;

import database.DatabaseConnection;
import models.DisasterTip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service for managing disaster tips.
 */
public class DisasterTipService {

    private final Connection connection;

    public DisasterTipService() {
        Connection conn = null;
        try {
            conn = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            System.err.println("Error while getting connection in DisasterTipService: " + e.getMessage());
        }
        this.connection = conn;
    }

    /**
     * Fetches all tips for a specific disaster type.
     *
     * @param disasterType The type of disaster.
     * @return List of disaster tips.
     * @throws SQLException If a database error occurs.
     */
    public List<DisasterTip> getTipsByDisasterType(String disasterType) {
        String query = "SELECT * FROM DisasterTips WHERE disasterType = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, disasterType);
            ResultSet rs = stmt.executeQuery();
            List<DisasterTip> tips = new ArrayList<>();
            while (rs.next()) {
                DisasterTip tip = new DisasterTip(
                        rs.getInt("id"),
                        rs.getString("disasterType"),
                        DisasterTip.TipCategory.valueOf(rs.getString("category").toUpperCase()),
                        rs.getString("tip")
                );
                tips.add(tip);
            }
            return tips;
        } catch (SQLException e) {
            System.err.println("Error fetching tips for disaster type: " + disasterType);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Adds a new disaster tip to the database.
     *
     * @param tip The DisasterTip object.
     * @throws SQLException If a database error occurs.
     */
    public void addDisasterTip(DisasterTip tip) {
        String query = "INSERT INTO DisasterTips (disasterType, category, tip) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, tip.getDisasterType());
            stmt.setString(2, tip.getCategory().toString());
            stmt.setString(3, tip.getTip());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding disaster tip: " + e.getMessage());
        }
    }
}
