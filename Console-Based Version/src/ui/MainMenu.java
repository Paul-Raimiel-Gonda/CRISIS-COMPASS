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
    public static void showMainMenu(int currentUserId) { // Accept currentUserId as a parameter
        while (true) { // Loop to stay in Main Menu until user logs out
            System.out.println("\nWelcome to the Main Menu!");
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
                    InventoryUI inventoryUI = new InventoryUI();
                    inventoryUI.displayInventoryMenu();
                    break;
                case 2:
                    DisasterTipUI disasterTipUI = new DisasterTipUI();
                    disasterTipUI.displayDisasterTipMenu();
                    break;
                case 3:
                    HelpRequestUI helpRequestUI = new HelpRequestUI();
                    helpRequestUI.displayHelpRequestMenu(currentUserId); // Pass currentUserId
                    break;
                case 4:
                    System.out.println("Disaster tracking functionality is not yet available.");
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return; // Exit Main Menu loop to log out
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
