package ui;

import disasters.*;
import models.DisasterTip;

import java.util.List;
import java.util.Scanner;

public class DisasterTipUI {

    public void displayDisasterTipMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⢀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢀⣤⣶⣿⣿⣿⣆⠘⠿⠟⢻⣿⣿⡇⢐⣷⣦⣄⡀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⢸⣿⣿⣿⣧⡄⠙⣿⣷⣶⣶⡿⠿⠿⢃⣼⡟⠻⣿⣿⣶⡄⠀⠀⠀⠀\n" +
                    "⠀⠀⢰⣷⣌⠙⠉⣿⣿⡟⢀⣿⣿⡟⢁⣤⣤⣶⣾⣿⡇⠸⢿⣿⠿⢃⣴⡄⠀         --------------------------------⠀\n" +
                    "⠀⠀⢸⣿⣿⣿⣿⠿⠋⣠⣾⣿⣿⠀⣾⣿⣿⣛⠛⢿⣿⣶⣤⣤⣴⣿⣿⣿⡆⠀               Disaster Tips Menu \n" +
                    "⠀⣴⣤⣄⣀⣠⣤⣴⣾⣿⣿⣿⣿⣆⠘⠿⣿⣿⣷⡄⢹⣿⣿⠿⠟⢿⣿⣿⣿⠀\n" +
                    "⠀⢸⣿⣿⡿⠛⠛⣻⣿⣿⣿⣿⣿⣿⣷⣦⣼⣿⣿⠃⣸⣿⠃⢰⣶⣾⣿⣿⡟⠀            1. Choose Disaster Type\n" +
                    "⠀⠀⢿⡏⢠⣾⣿⣿⡿⠋⣠⣄⡉⢻⣿⣿⡿⠟⠁⠀⠛⠛⠀⠘⠿⠿⠿⠋⠀⠀              2. Return to Main Menu\n" +
                    "⠀⠀⠀⠁⠘⢿⣿⣿⣷⣤⣿⣿⠗⠀⣉⣥⣴⣶⡶⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀          --------------------------------\n" +
                    "⠀⠀⠀⠀⣤⣀⡉⠛⠛⠋⣉⣠⣴⠿⢿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠈⠻⢿⣿⣿⣿⣿⡿⠋⣠⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
            System.out.print("                                              Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> selectDisasterType();
                case 2 -> {
                    System.out.println("Returning to Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void selectDisasterType() {
        Scanner scanner = new Scanner(System.in);
        Disaster disaster = null;

        while (disaster == null) {
            System.out.print("\nTYPHOON " + "            FLOOD\n" +
                    "EARTHQUAKE" + "          VOLCANIC ERUPTION\n" +
                    "DROUGHT\n\n " +
                    "ENTER DISASTER TYPE\n ");
            String disasterType = scanner.nextLine();

            if (disasterType.equalsIgnoreCase("back")) {
                System.out.println("Returning to Disaster Tips Menu...");
                return;
            }

            disaster = createDisasterObject(disasterType);

            if (disaster == null) {
                System.out.println("Invalid disaster type. Please try again.");
            }
        }

        displayTipCategories(disaster);
    }

    private void displayTipCategories(Disaster disaster) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Tip Categories for " + disaster.getName() + " ---\n");
            System.out.println("1. Preparation");
            System.out.println("2. During");
            System.out.println("3. After");
            System.out.println("4. Emergency");
            System.out.println("5. Return to Disaster Type Selection");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            String category = null; // Initialize the category
            switch (choice) {
                case 1 -> category = "Preparation";
                case 2 -> category = "During";
                case 3 -> category = "After";
                case 4 -> category = "Emergency";
                case 5 -> {
                    System.out.println("Returning to Disaster Type Selection...");
                    return; // Exit this method
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }

            if (category != null) {
                disaster.fetchTipsByCategory(category);
            }
        }
    }

    private Disaster createDisasterObject(String disasterType) {
        return switch (disasterType.toLowerCase()) {
            case "drought" -> new Drought();
            case "earthquake" -> new Earthquake();
            case "flood" -> new Flood();
            case "typhoon" -> new Typhoon();
            case "volcaniceruption" -> new VolcanicEruption();
            default -> null;
        };
    }
}
