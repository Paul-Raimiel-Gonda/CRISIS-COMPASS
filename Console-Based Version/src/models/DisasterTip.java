package models;

/**
 * Represents a tip or advice for managing a specific disaster.
 * Organized into categories such as "Before", "During", "After", and "Emergency Situations".
 */
public class DisasterTip {

    // Encapsulated fields
    private int tipId; // Unique identifier for the tip
    private String disasterType; // Example: "Flood", "Earthquake"
    private TipCategory category; // Enum for the tip category
    private String description; // The actual tip content

    /**
     * Enum to categorize disaster tips.
     */
    public enum TipCategory {
        BEFORE, DURING, AFTER, EMERGENCY
    }

    // Constructor
    public DisasterTip(int tipId, String disasterType, TipCategory category, String description) {
        this.tipId = tipId;
        this.disasterType = disasterType;
        this.category = category;
        this.description = description;
    }

    // Getters and setters
    public int getTipId() {
        return tipId;
    }

    public void setTipId(int tipId) {
        this.tipId = tipId;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public TipCategory getCategory() {
        return category;
    }

    public void setCategory(TipCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Displays the tip details.
     */
    public void displayTipDetails() {
        System.out.println("Tip ID: " + tipId);
        System.out.println("Disaster Type: " + disasterType);
        System.out.println("Category: " + category);
        System.out.println("Description: " + description);
    }
}
