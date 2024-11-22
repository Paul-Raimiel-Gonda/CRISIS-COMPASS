package disasters;

import java.util.List;

/**
 * Abstract base class representing common properties and behaviors for all disasters.
 */
public abstract class Disaster {

    // Encapsulated fields shared by all disasters
    protected String name; // Name of the disaster (e.g., "Typhoon")
    protected String description; // Brief description of the disaster

    /**
     * Constructor for Disaster.
     *
     * @param name        The name of the disaster.
     * @param description A brief description of the disaster.
     */
    protected Disaster(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getter for the disaster name
    public String getName() {
        return name;
    }

    // Getter for the disaster description
    public String getDescription() {
        return description;
    }

    /**
     * Abstract method to retrieve essential items for this type of disaster.
     * Each derived class must implement this method.
     *
     * @return A list of essential items.
     */
    public abstract List<String> getEssentialItems();

    /**
     * Abstract method to retrieve disaster-specific tips.
     * Each derived class must implement this method.
     *
     * @return A list of general tips for this disaster.
     */
    public abstract List<String> getGeneralTips();

    /**
     * Displays disaster details, showcasing polymorphism for different disaster types.
     */
    public void displayDetails() {
        System.out.println("Disaster: " + name);
        System.out.println("Description: " + description);
    }
}
