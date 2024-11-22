package services;

import models.InventoryItem;
import disasters.Disaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service for managing user inventories and disaster-specific essentials.
 */
public class InventoryService {

    // Encapsulated list of inventory items (per user simulation)
    private final Map<String, List<InventoryItem>> userInventories;

    /**
     * Constructor initializes the user inventory map.
     */
    public InventoryService(Map<String, List<InventoryItem>> userInventories) {
        this.userInventories = userInventories;
    }

    /**
     * Adds an item to the user's inventory.
     *
     * @param username The user's username.
     * @param item     The item to add.
     */
    public void addItem(String username, InventoryItem item) {
        userInventories.computeIfAbsent(username, k -> new ArrayList<>()).add(item);
    }

    /**
     * Retrieves the user's inventory.
     *
     * @param username The user's username.
     * @return A list of inventory items.
     */
    public List<InventoryItem> getInventory(String username) {
        return userInventories.getOrDefault(username, new ArrayList<>());
    }

    /**
     * Checks for essential items based on the disaster type.
     *
     * @param username      The user's username.
     * @param disasterType  The type of disaster.
     * @param disasterLogic The disaster-specific logic.
     * @return A list of missing essential items.
     */
    public List<String> checkMissingItems(String username, String disasterType, Disaster disasterLogic) {
        List<String> userItems = getInventory(username).stream()
                .map(InventoryItem::getItemName)
                .collect(Collectors.toList());

        return disasterLogic.getEssentialItems().stream()
                .filter(item -> !userItems.contains(item))
                .collect(Collectors.toList());
    }
}
