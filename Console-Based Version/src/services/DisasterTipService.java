package services;

import database.DatabaseConnection;
import models.DisasterTip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Service layer to fetch disaster tips.
 */
public class DisasterTipService {

    /**
     * Fetch tips by disaster type and category from the database.
     *
     * @param disasterType The type of disaster (e.g., "Flood", "Earthquake").
     * @param category     The tip category (e.g., "Preparation", "During", "After", "Emergency").
     * @return List of tips as strings.
     */
    public List<String> getTipsByCategory(String disasterType, String category) {
        List<String> tips = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT tip_text FROM DisasterTips WHERE disaster_type = ? AND category = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, disasterType);
                stmt.setString(2, category);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        tips.add(rs.getString("tip_text"));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching tips: " + e.getMessage());
            e.printStackTrace();
        }

        return tips;
    }

    /**
     * Fetch all tips related to a specific disaster type.
     *
     * @param disasterType The type of disaster (e.g., "Flood", "Earthquake").
     * @return List of DisasterTip objects containing all tips for the disaster.
     */
    public List<DisasterTip> getAllTipsByDisasterType(String disasterType) {
        List<DisasterTip> tips = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            String query = "SELECT tip_id, disaster_type, category, tip_text FROM DisasterTips WHERE disaster_type = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, disasterType);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        DisasterTip tip = new DisasterTip(
                                rs.getInt("tip_id"),
                                rs.getString("disaster_type"),
                                rs.getString("category"),
                                rs.getString("tip_text")
                        );
                        tips.add(tip);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching tips: " + e.getMessage());
            e.printStackTrace();
        }

        return tips;
    }
}
