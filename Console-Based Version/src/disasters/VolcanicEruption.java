package disasters;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Volcanic Eruption disaster.
 * Extends the abstract Disaster class to provide volcano-specific details and behavior.
 */
public class VolcanicEruption extends Disaster {

    /**
     * Constructor for Volcanic Eruption.
     */
    public VolcanicEruption() {
        super("Volcanic Eruption", "A violent eruption of molten rock, ash, and gases from a volcano.");
    }

    /**
     * Returns a list of essential items specific to a Volcanic Eruption.
     *
     * @return A list of essential items.
     */
    @Override
    public List<String> getEssentialItems() {
        return Arrays.asList(
                "N95 masks or respirators",
                "Goggles to protect eyes from ash",
                "Long-sleeve shirts and pants",
                "Sturdy shoes",
                "Portable radio",
                "First aid kit",
                "Non-perishable food and water",
                "Plastic sheeting and duct tape",
                "Flashlight with extra batteries"
        );
    }

    /**
     * Returns general tips for preparing and handling a Volcanic Eruption.
     *
     * @return A list of general tips.
     */
    @Override
    public List<String> getGeneralTips() {
        return Arrays.asList(
                "Stay indoors during an eruption to avoid inhaling ash.",
                "Seal windows and doors with damp towels or plastic sheeting to keep ash out.",
                "Wear protective gear, including masks and goggles, if going outside is necessary.",
                "Monitor updates from local authorities and be ready to evacuate if needed.",
                "Avoid driving in heavy ashfall, as it can damage engines and reduce visibility."
        );
    }

    /**
     * Displays Volcanic Eruption-specific details, leveraging polymorphism.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Essential Items: " + String.join(", ", getEssentialItems()));
        System.out.println("General Tips: " + String.join("; ", getGeneralTips()));
    }
}
