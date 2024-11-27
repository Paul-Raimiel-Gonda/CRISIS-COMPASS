package ui;

import java.util.Scanner;

public class MainMenu {

    // Declare a private static Scanner object
    private static final Scanner scanner = new Scanner(System.in);

    // Getter method for the scanner
    public static Scanner getScanner() {
        return scanner;
    }

    // Method to display and handle the main menu
    public static void showMainMenu() {
        System.out.println("Welcome to the Main Menu!");
        System.out.println("1. Disaster Inventory");
        System.out.println("2. Disaster Tips");
        System.out.println("3. Request Help");
        System.out.println("4. Track Disaster");
        System.out.println("5. Log out");
        System.out.print("Please choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                // Create an instance of InventoryUI and show inventory options
                InventoryUI inventoryUI = new InventoryUI();
                inventoryUI.displayInventoryMenu();
                break;
            case 2:
                // Create an instance of DisasterTipUI and show disaster tip menu
                DisasterTipUI disasterTipUI = new DisasterTipUI();
                disasterTipUI.displayDisasterTipMenu();
                break;
            case 3:
                // Create an instance of HelpRequestUI and show help request menu
                HelpRequestUI helpRequestUI = new HelpRequestUI();
                helpRequestUI.displayHelpRequestMenu();
                break;
            case 4:
                // Placeholder for disaster tracking functionality
                System.out.println("Disaster tracking functionality is not yet available.");
                break;
            case 5:
                // Log out and return to UserUI menu
                System.out.println("Logging out...");
                UserUI.showUserMenu(); // Return to user menu
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                showMainMenu(); // Recursively show the menu again if invalid choice
                break;
        }
    }
}
