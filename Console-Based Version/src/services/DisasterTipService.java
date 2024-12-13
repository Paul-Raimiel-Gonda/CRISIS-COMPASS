package services;

import database.DatabaseConnection;
import models.DisasterTip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//HANDLES ALL OPERATIONS FOR DISASTER TIPS
public class DisasterTipService {
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
