package models;

/**
 * Represents a tip related to a specific disaster type and situation.
 */
public class DisasterTip {

    private int id;
    private String disasterType;
    private TipCategory category;
    private String tip;

    /**
     * Enum for categorizing disaster tips.
     */
    public enum TipCategory {
        BEFORE, DURING, AFTER, EMERGENCY
    }

    /**
     * Constructor for DisasterTip.
     *
     * @param id            Unique identifier for the tip.
     * @param disasterType  The type of disaster (e.g., "Flood", "Earthquake").
     * @param category      The category of the tip (e.g., BEFORE, DURING).
     * @param tip           The tip text.
     */
    public DisasterTip(int id, String disasterType, TipCategory category, String tip) {
        this.id = id;
        this.disasterType = disasterType;
        this.category = category;
        this.tip = tip;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Getter for disaster type
    public String getDisasterType() {
        return disasterType;
    }

    // Getter for category
    public TipCategory getCategory() {
        return category;
    }

    // Getter for the tip text
    public String getTip() {
        return tip;
    }

    // Displays the details of the tip
    public void displayTipDetails() {
        System.out.println("Disaster Type: " + disasterType);
        System.out.println("Category: " + category);
        System.out.println("Tip: " + tip);
    }
}
