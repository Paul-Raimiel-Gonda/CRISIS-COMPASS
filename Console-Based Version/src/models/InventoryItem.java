package models;

/**
 * Represents an item in the user's emergency inventory.
 */
public class InventoryItem {

    private int itemId; // Unique identifier for the item
    private String itemName; // Name of the item
    private String category; // Example: "Food", "Medicine", "Tools"
    private boolean essential; // Indicates if the item is essential for a specific disaster
    private int quantity; // Quantity of the item the user has

    // Constructor
    public InventoryItem(int itemId, String itemName, String category, boolean essential, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.essential = essential;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Displays the details of the inventory item.
     */
    public void displayItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Item Name: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Essential: " + (essential ? "Yes" : "No"));
        System.out.println("Quantity: " + quantity);
    }
}
