package ui;

import disasters.*;
import utils.ExceptionHandlingUtil;

import java.util.Scanner;

public class TrackDisasterUI {

    public void displayDisasterTrackingMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                        "⣿⡿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⢿⣿\n" +
                        "⣿⡇⠀⢠⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⠀⠀⠀⠀⠀⠀⠀⢸⣿          ------------------------------\n" +
                        "⣿⡇⠀⢸⠛⠿⠿⠿⠄⠀⠸⣿⣿⣿⣿⣿⣧⣤⣤⣤⣿⠀⠀⠀⠀⠀⠀⠀⢸⣿              DISASTER TRACKING MENU\n" +
                        "⣿⡇⠀⢸⣶⣶⣶⣦⣤⠀⠀⢿⣿⣿⣿⣿⣧⣤⣤⣤⣿⠀⠀⠀⠀⠀⠀⠀⢸⣿\n" +
                        "⣿⡇⠀⢸⣿⣿⣿⣿⣿⣧⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⢰⡶⠶⠶⣶⠀⢸⣿            1. Drought\n" +
                        "⣿⡇⠀⢸⣿⣿⣿⣿⣿⣿⡆⢀⣿⣿⣿⣿⠿⠿⠟⠛⣿⠀⠘⠛⠛⠛⠛⠀⢸⣿            2. Earthquake\n" +
                        "⣿⡇⠀⢸⣿⣿⣿⣿⣿⣿⣿⡞⢻⣇⣤⣤⣤⣶⣶⣿⣿⠀⢸⡟⠛⠛⣿⠀⢸⣿            3. Flood\n" +
                        "⣿⡇⠀⢸⣿⣿⣿⣿⣿⣿⠟⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⠀⠘⠛⠛⠛⠛⠀⢸⣿            4. Typhoon\n" +
                        "⣿⡇⠀⢸⣿⣿⣿⣿⣿⣋⣤⣤⣄⣀⢻⣿⣿⣿⣿⣿⣿⠀⢀⣴⠖⠲⣦⠀⢸⣿            5. Volcanic Eruption\n" +
                        "⣿⡇⠀⢸⣿⣿⣿⣿⣿⣿⡟⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⠀⠸⣧⡀⢀⣿⠀⢸⣿            6. Back to Main Menu\n" +
                        "⣿⡇⠀⢸⣿⣿⣿⣿⣿⣿⡇⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠉⠛⠛⠁⠀⢸⣿          ------------------------------\n" +
                        "⣿⡇⠀⠘⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠀⠀⠀⠀⠀⠀⠀⢸⣿\n" +
                        "⣿⣷⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿\n" +
                        "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
                System.out.println("\n:");
                System.out.print("                                                Choose a disaster to track: ");
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

                System.out.println("\nTRACKING INFORMATION: " + disaster.getName());
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
