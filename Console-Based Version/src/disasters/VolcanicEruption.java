package disasters;

/**
 * Represents the disaster type: Volcanic Eruption.
 */
public class VolcanicEruption extends Disaster {
    public VolcanicEruption() {
        super("Volcanic Eruption", "An eruption of molten rock, ash, and gases from a volcano.");
    }

    @Override
    public String getTrackingLink() {
        return "https://www.phivolcs.dost.gov.ph/index.php/volcano-hazard/volcano-bulletin2";
    }

    @Override
    public void displayTrackingTips() {
        System.out.println("Tips for tracking volcanic eruptions:");
        System.out.println("1. Visit PHIVOLCS' Volcano Bulletins page for active volcano updates.");
        System.out.println("2. Monitor ashfall advisories and hazard maps.");
        System.out.println("3. Stay prepared for evacuation in high-risk zones.");
    }
}
