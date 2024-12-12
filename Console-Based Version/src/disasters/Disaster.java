package disasters;

import services.DisasterTipService;
import java.util.List;

/**
 * Abstract class representing a generic disaster.
 */
public abstract class Disaster {
    private final String name;
    private final String description;
    private final DisasterTipService disasterTipService;

    public Disaster(String name, String description) {
        this.name = name;
        this.description = description;
        this.disasterTipService = new DisasterTipService();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Fetch tips for a specific category using the disaster's type.
     *
     * @param category The tip category (BEFORE, DURING, AFTER, EMERGENCY).
     */
    public void fetchTipsByCategory(String category) {
        System.out.println("\nTips for " + getName() + " (" + category + "):");
        List<String> tips = disasterTipService.getTipsByCategory(getName(), category);

        if (tips.isEmpty()) {
            System.out.println("No tips available for this category.");
        } else {
            tips.forEach(System.out::println);
        }
    }

    /**
     * Abstract method to return the government tracking link for this disaster type.
     */
    public abstract String getTrackingLink();

    /**
     * Abstract method to display tracking tips for the disaster.
     */
    public abstract void displayTrackingTips();
}
