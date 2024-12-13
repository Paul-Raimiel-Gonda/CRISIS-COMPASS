package disasters;

/**
 * Represents the disaster type: Flood.
 */
public class Flood extends Disaster {
    public Flood() {
        super("Flood", "\n\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠟⢁⡈⠻⣦⣀⠺⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⣀⣴⣿⣿⣦⣀⠙⢦⡈⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⣠⠴⠋⣠⣾⣿⣿⣿⣿⣿⣿⣷⣄⠙⠦⣄⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠐⠚⠁⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⠈⠓⠂⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠉⣉⡉⢹⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⡿⠇⠘⠿⣿⣿⣿⣿⠿⠛⠻⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⣀⣤⠶⠟⢷⣦⡉⠛⢀⣴⠾⠻⣶⣌⠙⠋⣡⡶⠟⢷⣦⡀⠀⢀⣠⡴⠀⠀\n" +
                "           ⠀⠈⠋⠁⠀⠀⠀⠈⠛⠛⠛⠁⠀⠀⠀⠙⠛⠛⠋⠀⠀⠀⠈⠛⠛⠛⠁⠀⠀⠀\n" +
                "           ⠀⠀⣠⡶⠟⠛⠳⣦⣀⢀⣠⡶⠟⠛⢶⣄⡀⣀⣴⠾⠛⠳⣦⣀⠀⣀⣴⠾⠀⠀\n" +
                "           ⠀⠀⠁⠀⠀⠀⠀⠈⠉⠉⠉⠀⠀⠀⠀⠉⠉⠉⠁⠀⠀⠀⠈⠉⠉⠉⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n\n" +
                "An overflow of water that submerges land which is usually dry.\n");
    }

    @Override
    public String getTrackingLink() {
        return "https://www.pagasa.dost.gov.ph/flood#flood-information";
    }

    @Override
    public void displayTrackingTips() {
        System.out.println("Tips for tracking floods:\n");
        System.out.println("1. Check PAGASA's flood monitoring tools and weather forecasts.");
        System.out.println("2. Follow local government advisories on evacuation and safety.");
        System.out.println("3. Monitor river levels and rainfall intensity in your area.");
    }
}
