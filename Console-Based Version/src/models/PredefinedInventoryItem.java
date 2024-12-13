package models;

import java.util.List;

//CLASS FOR PREDEFINED ITEMS
public class PredefinedInventoryItem {
    private int itemId;
    private String itemName;
    private String category;
    private String description;
    private boolean essential;
    private List<String> applicableDisasters;

    public PredefinedInventoryItem(int itemId, String itemName, String category, String description,
                                   boolean essential, List<String> applicableDisasters) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.description = description;
        this.essential = essential;
        this.applicableDisasters = applicableDisasters;
    }

    // Getters and Setters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEssential() {
        return essential;
    }

    public void setEssential(boolean essential) {
        this.essential = essential;
    }

    public List<String> getApplicableDisasters() {
        return applicableDisasters;
    }

    public void setApplicableDisasters(List<String> applicableDisasters) {
        this.applicableDisasters = applicableDisasters;
    }

    @Override
    public String toString() {
        return "Name: " + itemName +
                "\nCategory: " + category +
                "\nDescription: " + description +
                "\nEssential: " + (essential ? "Yes" : "No") +
                "\nApplicable Disasters: " + String.join(", ", applicableDisasters) +
                "\n";
    }

    public void displayItemDetails() {
        System.out.println(this.toString());
    }
}
