package models;

public class DisasterTip {
    private int id;
    private String disasterType;
    private String category; // Enum as String: "Preparation", "During", etc.
    private String tip;

    public DisasterTip(int id, String disasterType, String category, String tip) {
        this.id = id;
        this.disasterType = disasterType;
        this.category = category;
        this.tip = tip;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public String getCategory() {
        return category;
    }

    public String getTip() {
        return tip;
    }

    // Display Method
    public void displayTip() {
        System.out.println("- " + tip);
    }
}
