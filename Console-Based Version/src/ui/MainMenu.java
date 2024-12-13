package ui;

import java.util.Scanner;
import utils.ExceptionHandlingUtil;

public class MainMenu {

    // Declare a private static Scanner object
    private static final Scanner scanner = new Scanner(System.in);

    // Getter method for the scanner
    public static Scanner getScanner() {
        return scanner;
    }

    // Method to display and handle the main menu
    public static void showMainMenu(int currentUserId) {// Accept currentUserId as a parameter
        ExceptionHandlingUtil.clearScreen();
        while (true) {
            System.out.println("\n\n" +
                    " ██████ ██████  ██ ███████ ██ ███████      ██████  ██████  ███    ███ ██████   █████  ███████ ███████ \n" +
                    "██      ██   ██ ██ ██      ██ ██          ██      ██    ██ ████  ████ ██   ██ ██   ██ ██      ██      \n" +
                    "██      ██████  ██ ███████ ██ ███████     ██      ██    ██ ██ ████ ██ ██████  ███████ ███████ ███████ \n" +
                    "██      ██   ██ ██      ██ ██      ██     ██      ██    ██ ██  ██  ██ ██      ██   ██      ██      ██ \n" +
                    " ██████ ██   ██ ██ ███████ ██ ███████      ██████  ██████  ██      ██ ██      ██   ██ ███████ ███████ \n" +
                    "                                                                                                      \n" +
                    "------------------------------- A DISASTER PREPARATION ASSISTANT -------------------------------------\n\n" +
                    "                                         MAIN MENU                                                    \n");
            System.out.println("1. Disaster Inventory");
            System.out.println("2. Disaster Tips");
            System.out.println("3. Request Help");
            System.out.println("4. Track Disaster");
            System.out.println("5. Log out\n");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    TrackDisasterUI trackDisasterUI = new TrackDisasterUI();
                    trackDisasterUI.displayDisasterTrackingMenu();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    UserUI.showUserMenu(); // Exit Main Menu loop to log out
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
