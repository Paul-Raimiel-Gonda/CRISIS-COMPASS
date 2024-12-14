package disasters;

import services.DisasterTipService;
import java.util.List;

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

    public void fetchTipsByCategory(String category) {
        System.out.println("\nTips for " + getName() + " (" + category + "):\n");
        List<String> tips = disasterTipService.getTipsByCategory(getName(), category);

        if (tips.isEmpty()) {
            System.out.println("No tips available for this category.");
        } else {
            tips.forEach(System.out::println);
        }
    }

  //returns government aganecy links
    public abstract String getTrackingLink();

   //tracking tips
    public abstract void displayTrackingTips();
}
