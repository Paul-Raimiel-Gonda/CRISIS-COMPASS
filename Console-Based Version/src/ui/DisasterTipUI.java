package ui;

import services.DisasterTipService;
import models.DisasterTip;

import java.util.List;
import java.util.Scanner;

/**
 * Handles displaying disaster tips to users.
 */
public class DisasterTipUI {

    private final DisasterTipService disasterTipService;

    public DisasterTipUI() {
        disasterTipService = new DisasterTipService();
    }

    public void displayDisasterTipMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter disaster type (e.g., Flood, Earthquake): ");
        String disasterType = scanner.nextLine();

        try {
            List<DisasterTip> tips = disasterTipService.getTipsByDisasterType(disasterType);
            if (tips.isEmpty()) {
                System.out.println("No tips found for " + disasterType + ".");
            } else {
                System.out.println("Tips for " + disasterType + ":");
                tips.forEach(DisasterTip::displayTipDetails);
            }
        } catch (Exception e) {
            System.out.println("Error fetching disaster tips: " + e.getMessage());
        }
    }
}
