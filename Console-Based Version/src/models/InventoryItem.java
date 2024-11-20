package models;

/**
 * Represents an item in the emergency inventory.
 * Demonstrates encapsulation and integrates with disaster-specific inventory management.
 */
public class InventoryItem {

    // Encapsulated fields
    private int itemId; // Unique identifier for the item
    private String itemName; // Name of the item
    private String category; // Example: "Food", "Medicine", "Tools"
    private boolean essential; // Indicates if the item is essential for a specific disaster

    // Constructor
    public InventoryItem(int itemId, String itemName, String category, boolean essential) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.essential = essential;
    }

    // Getters and setters
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isEssential() {
        return essential;
    }

    public void setEssential(boolean essential) {
        this.essential = essential;
    }

    /**
     * Displays the details of the inventory item.
     */
    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Essential: " + (essential ? "Yes" : "No"));
    }

    /**
     * Determines if the item is suitable for a specific disaster type.
     * Example of future polymorphism or logic extension.
     *
     * @param disasterType The type of disaster to check against.
     * @return true if the item is suitable, false otherwise.
     */
    public boolean isSuitableForDisaster(String disasterType) {
        // Logic can be expanded to check disaster-specific suitability
        return essential; // Placeholder logic
    }
}
