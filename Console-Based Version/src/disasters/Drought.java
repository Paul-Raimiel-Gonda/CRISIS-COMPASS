package disasters;

/**
 * Represents the disaster type: Drought.
 */
public class Drought extends Disaster {
    public Drought() {
        super("Drought", "A prolonged period of abnormally low rainfall leading to a water shortage.");
    }

    @Override
    public String getTrackingLink() {
        return "https://www.pagasa.dost.gov.ph/climate-monitoring";
    }

    @Override
    public void displayTrackingTips() {
        System.out.println("Tips for tracking droughts:");
        System.out.println("1. Monitor rainfall and climate data on PAGASA's website.");
        System.out.println("2. Check advisories on water conservation measures.");
        System.out.println("3. Stay updated on El Niño and La Niña developments.");
    }
}
