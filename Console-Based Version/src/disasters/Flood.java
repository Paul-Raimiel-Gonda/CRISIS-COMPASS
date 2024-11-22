package disasters;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Flood disaster.
 * Extends the abstract Disaster class to provide flood-specific details and behavior.
 */
public class Flood extends Disaster {

    /**
     * Constructor for Flood.
     */
    public Flood() {
        super("Flood", "An overflow of water submerging land that is usually dry, caused by heavy rainfall or other factors.");
    }

    /**
     * Returns a list of essential items specific to a Flood.
     *
     * @return A list of essential items.
     */
    @Override
    public List<String> getEssentialItems() {
        return Arrays.asList(
                "Waterproof bags for valuables",
                "Non-perishable food",
                "Bottled water",
                "Flashlights with extra batteries",
                "First aid kit",
                "Rubber boots",
                "Raincoat or waterproof clothing",
                "Portable phone charger or power bank",
                "Multi-purpose tools"
        );
    }

    /**
     * Returns general tips for preparing and handling a Flood.
     *
     * @return A list of general tips.
     */
    @Override
    public List<String> getGeneralTips() {
        return Arrays.asList(
                "Avoid walking or driving through floodwaters, as it may be deeper than it appears.",
                "Turn off utilities like gas and electricity if flooding occurs in your area.",
                "Keep emergency supplies and important documents in waterproof containers.",
                "Move to higher ground immediately if flash floods are imminent.",
                "Listen to local authorities and evacuation orders for guidance."
        );
    }

    /**
     * Displays Flood-specific details, leveraging polymorphism.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Essential Items: " + String.join(", ", getEssentialItems()));
        System.out.println("General Tips: " + String.join("; ", getGeneralTips()));
    }
}
