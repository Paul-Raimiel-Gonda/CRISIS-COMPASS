package services;

import database.DatabaseConnection;
import models.PredefinedInventoryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryService {

    private final Connection connection;

    public InventoryService() {
        try {
            this.connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database connection in InventoryService.", e);
        }
    }

    // Fetch all predefined items
    public List<PredefinedInventoryItem> getAllPredefinedItems() {
        String query = "SELECT * FROM PredefinedInventory";
        List<PredefinedInventoryItem> items = new ArrayList<>();

        if (!isConnectionValid()) return items; // Avoid running query if the connection is invalid.

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                List<String> disasters = Arrays.asList(rs.getString("applicableDisasters").split(","));
                PredefinedInventoryItem item = new PredefinedInventoryItem(
                        rs.getInt("itemId"),
                        rs.getString("itemName"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getBoolean("essential"),
                        disasters
                );
                items.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching predefined items: " + e.getMessage());
        }
        return items;
    }

    // Fetch items by disaster type
    public List<PredefinedInventoryItem> getItemsByDisasterType(String disasterType) {
        String query = "SELECT * FROM PredefinedInventory WHERE FIND_IN_SET(?, applicableDisasters)";
        List<PredefinedInventoryItem> items = new ArrayList<>();

        if (!isConnectionValid()) return items;

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, disasterType);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                List<String> disasters = Arrays.asList(rs.getString("applicableDisasters").split(","));
                PredefinedInventoryItem item = new PredefinedInventoryItem(
                        rs.getInt("itemId"),
                        rs.getString("itemName"),
                        rs.getString("category"),
                        rs.getString("description"),
                        rs.getBoolean("essential"),
                        disasters
                );
                items.add(item);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching items by disaster type: " + e.getMessage());
        }
        return items;
    }

    // Fetch missing items for a specific disaster
    public List<PredefinedInventoryItem> getMissingItemsByDisasterType(List<PredefinedInventoryItem> userItems, String disasterType) {
        List<PredefinedInventoryItem> allItems = getItemsByDisasterType(disasterType);
        List<PredefinedInventoryItem> missingItems = new ArrayList<>();

        for (PredefinedInventoryItem item : allItems) {
            if (item.isEssential() && userItems.stream().noneMatch(userItem -> userItem.getItemId() == item.getItemId())) {
                missingItems.add(item);
            }
        }
        return missingItems;
    }

    // Utility method to validate connection
    private boolean isConnectionValid() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            System.err.println("Database connection is invalid: " + e.getMessage());
            return false;
        }
    }
}
