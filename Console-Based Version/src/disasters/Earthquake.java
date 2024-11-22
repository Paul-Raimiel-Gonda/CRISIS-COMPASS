package disasters;

import java.util.Arrays;
import java.util.List;

/**
 * Represents an Earthquake disaster.
 * Extends the abstract Disaster class to provide earthquake-specific details and behavior.
 */
public class Earthquake extends Disaster {

    /**
     * Constructor for Earthquake.
     */
    public Earthquake() {
        super("Earthquake", "A sudden and violent shaking of the ground caused by seismic activity.");
    }

    /**
     * Returns a list of essential items specific to an Earthquake.
     *
     * @return A list of essential items.
     */
    @Override
    public List<String> getEssentialItems() {
        return Arrays.asList(
                "Emergency whistle",
                "First aid kit",
                "Non-perishable food",
                "Bottled water",
                "Flashlights with extra batteries",
                "Sturdy shoes",
                "Dust masks",
                "Protective gloves",
                "Portable radio"
        );
    }

    /**
     * Returns general tips for preparing and handling an Earthquake.
     *
     * @return A list of general tips.
     */
    @Override
    public List<String> getGeneralTips() {
        return Arrays.asList(
                "Secure heavy furniture and appliances to walls.",
                "Identify safe spots in each room, such as under sturdy tables or against interior walls.",
                "Prepare an emergency kit with essential supplies.",
                "During an earthquake, drop, cover, and hold on to protect yourself.",
                "After the shaking stops, check for injuries and damages, and avoid entering damaged buildings."
        );
    }

    /**
     * Displays Earthquake-specific details, leveraging polymorphism.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Essential Items: " + String.join(", ", getEssentialItems()));
        System.out.println("General Tips: " + String.join("; ", getGeneralTips()));
    }
}
