package ui;

import disasters.*;
import utils.ExceptionHandlingUtil;

import java.util.Scanner;

public class TrackDisasterUI {

    public void displayDisasterTrackingMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nDisaster Tracking Menu:");
                System.out.println("1. Drought");
                System.out.println("2. Earthquake");
                System.out.println("3. Flood");
                System.out.println("4. Typhoon");
                System.out.println("5. Volcanic Eruption");
                System.out.println("6. Back to Main Menu");
                System.out.print("Choose a disaster to track: ");
                int choice = Integer.parseInt(scanner.nextLine());

                Disaster disaster;
                switch (choice) {
                    case 1 -> disaster = new Drought();
                    case 2 -> disaster = new Earthquake();
                    case 3 -> disaster = new Flood();
                    case 4 -> disaster = new Typhoon();
                    case 5 -> disaster = new VolcanicEruption();
                    case 6 -> {
                        return; // Exit to Main Menu
                    }
                    default -> {
                        System.out.println("Invalid choice. Please try again.");
                        continue;
                    }
                }

                System.out.println("\nTracking information for: " + disaster.getName());
                System.out.println("Description: " + disaster.getDescription());
                System.out.println("Tracking Link: " + disaster.getTrackingLink());
                disaster.displayTrackingTips();

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                ExceptionHandlingUtil.handleException(e);
            }
        }
    }
}
