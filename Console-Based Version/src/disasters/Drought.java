package disasters;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Drought disaster.
 * Extends the abstract Disaster class to provide drought-specific details and behavior.
 */
public class Drought extends Disaster {

    /**
     * Constructor for Drought.
     */
    public Drought() {
        super("Drought", "A prolonged period of abnormally low rainfall, leading to a shortage of water.");
    }

    /**
     * Returns a list of essential items specific to a Drought.
     *
     * @return A list of essential items.
     */
    @Override
    public List<String> getEssentialItems() {
        return Arrays.asList(
                "Stored drinking water (minimum one gallon per person per day)",
                "Rehydration salts or electrolytes",
                "Water purification tablets or filters",
                "Moisturizing lotion to prevent skin dryness",
                "Wide-brimmed hats and sunscreen for outdoor protection",
                "Non-perishable, low-water food items",
                "Buckets and containers for water storage",
                "Water-efficient appliances or tools",
                "Emergency cash for water purchases"
        );
    }

    /**
     * Returns general tips for preparing and handling a Drought.
     *
     * @return A list of general tips.
     */
    @Override
    public List<String> getGeneralTips() {
        return Arrays.asList(
                "Conserve water by fixing leaks and using water-efficient appliances.",
                "Store enough drinking water for the entire household in sealed containers.",
                "Reduce outdoor water usage, such as watering lawns or washing cars.",
                "Use greywater (recycled water from sinks or showers) for non-drinking purposes.",
                "Stay hydrated and limit outdoor activities during the hottest parts of the day."
        );
    }

    /**
     * Displays Drought-specific details, leveraging polymorphism.
     */
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Essential Items: " + String.join(", ", getEssentialItems()));
        System.out.println("General Tips: " + String.join("; ", getGeneralTips()));
    }
}
