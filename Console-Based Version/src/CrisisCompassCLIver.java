import ui.MainMenu;
import ui.UserUI;

import java.util.Scanner;

public class CrisisCompassCLIver {

    public static void main(String[] args) {
        // Display the user menu to allow login or registration
        UserUI.showUserMenu();

        boolean running = true;
        Scanner scanner = new Scanner(System.in); // Declare a local scanner instance

        while (running) {
            // Show the main menu after login/registration
            MainMenu.showMainMenu();

            System.out.print("\nDo you want to exit the application? (yes/no): ");
            String exitChoice = scanner.nextLine().trim().toLowerCase();

            if (exitChoice.equals("yes")) {
                running = false; // Exit the loop and terminate the program
                System.out.println("Thank you for using Crisis Compass. Goodbye!");
            }
        }
    }
}