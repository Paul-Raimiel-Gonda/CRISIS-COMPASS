package disasters;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Typhoon disaster.
 * Extends the abstract Disaster class to provide typhoon-specific details and behavior.
 */
public class Typhoon extends Disaster {

    /**
     * Constructor for Typhoon.
     */
    public Typhoon() {
        super("Typhoon", "A powerful tropical storm characterized by strong winds and heavy rainfall.");
    }

    /**
     * Returns a list of essential items specific to a Typhoon.
     *
     * @return A list of essential items.
     */
    @Override
    public List<String> getEssentialItems() {
        return Arrays.asList(
                "Portable radio",
                "Flashlights with extra batteries",
                "First aid kit",
                "Waterproof clothing",
                "Non-perishable food",
                "Drinking water",
                "Power banks",
                "Emergency whistle",
                "Multi-purpose tools"
        );
    }

    /**
     * Returns general tips for preparing and handling a Typhoon.
     *
     * @return A list of general tips.
     */
    @Override
    public List<String> getGeneralTips() {
        return Arrays.asList(
                "Secure outdoor items to prevent them from becoming projectiles.",
                "Charge all electronic devices and ensure power banks are full.",
                "Reinforce windows and doors with storm shutters or plywood.",
                "Evacuate to a safe location if instructed by local authorities.",
                "Avoid low-lying and flood-prone areas."
        );
    }

    /**
     * Displays Typhoon-specific details, leveraging polymorphism.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Essential Items: " + String.join(", ", getEssentialItems()));
        System.out.println("General Tips: " + String.join("; ", getGeneralTips()));
    }
}
