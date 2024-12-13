import ui.MainMenu;
import ui.UserUI;

import java.util.Scanner;

public class CrisisCompassCLIver {

    public static void main(String[] args) {
        int currentUserId = UserUI.showUserMenu();

        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            MainMenu.showMainMenu(currentUserId);

            System.out.print("\nDo you want to exit the application? (yes/no): ");
            String exitChoice = scanner.nextLine().trim().toLowerCase();

            if (exitChoice.equals("yes")) {
                running = false;
                System.out.println("Thank you for using Crisis Compass. Goodbye!");
            }
        }
    }
}
