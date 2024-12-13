package disasters;

/**
 * Represents the disaster type: Earthquake.
 */
public class Earthquake extends Disaster {
    public Earthquake() {
        super("Earthquake", "\n\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣦⣴⡄⠀⠀⢀⣾⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⢀⡀⠀⠀⠀⣿⣿⣷⠀⢀⣾⣿⡇⠀⠀⣀⣴⡞⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⢿⣦⡀⠀⢿⣿⣿⣧⣾⣿⣿⣧⣴⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠘⣿⣿⣦⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⣠⣶⠃⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⡟⣿⣿⣿⣿⣿⣷⣿⣿⡟⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⢿⣿⣿⣶⣿⣿⣿⠉⠻⣿⠀⠹⠟⠉⢰⣿⡿⣿⣿⣷⣶⡶⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⢻⣿⣿⣿⣷⠈⠀⠀⠉⠀⠀⠀⠀⠊⢁⣾⣿⣿⣿⡟⠁⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡾⠋⠀⠀⠘⢷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣧⠀⠀⠀⠀⠀⠀⢻⣧⣤⣀⣀⠀⠀⠀⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⢰⡶⠶⠶⢿⡟⠛⠛⠋⠁⠀⢀⣠⣴⠾⠛⠉⠉⠉⠙⠛⣻⡦⠀⠀⠀⠀\n" +
                "           ⠀⠀⠀⠀⣿⠀⠀⢸⣷⠀⠀⠀⠀⠀⠀⠻⣿⣦⣄⠀⠀⠀⠀⣴⡿⣶⣦⣤⣄⠀\n" +
                "           ⠀⠀⣀⣤⣿⡇⠀⠈⠻⣿⣶⣤⡀⠀⠀⠀⠈⢻⣿⡇⠀⢀⣾⡿⠀⠀⠉⠙⠻⠀\n" +
                "           ⠀⣿⣿⣿⡿⠃⠀⠀⠀⢈⣿⣿⠇⠀⠀⠀⣰⣿⣿⡇⠀⠀⠘⢿⣷⣤⡀⠀⠀⠀\n" +
                "           ⠀⠉⠉⠉⠀⠀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⠉⠉⠉⠁⠀⠀⠀⠀⠉⠉⠉⠁⠀⠀\n\n" +
                "A sudden and violent shaking of the ground, often causing great destruction.\n");
    }

    @Override
    public String getTrackingLink() {
        return "https://www.phivolcs.dost.gov.ph/index.php/earthquake/earthquake-information3";
    }

    @Override
    public void displayTrackingTips() {
        System.out.println("Tips for tracking earthquakes:\n");
        System.out.println("1. Visit the PHIVOLCS website for earthquake bulletins and maps.");
        System.out.println("2. Use mobile apps for real-time earthquake alerts.");
        System.out.println("3. Stay informed about earthquake-prone zones in your area.");
    }
}
