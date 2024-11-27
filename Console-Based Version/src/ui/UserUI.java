package ui;

import java.util.Scanner;

public class UserUI {

    private static final Scanner scanner = new Scanner(System.in);

    // Method for user registration
    public static void registerUser() {
        System.out.println("Please enter your details to register:");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Add actual registration logic here (e.g., hash password, save to database)

        System.out.println("Registration successful!");
    }

    // Method for user login
    public static void loginUser() {
        System.out.println("Login to your account:");
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Add actual login logic here (e.g., verify credentials)

        System.out.println("Login successful!");
        MainMenu.showMainMenu(); // Navigate to the main menu after login
    }

    // Method to display the user registration or login menu
    public static void showUserMenu() {
        while (true) {
            System.out.println("\nWelcome to Crisis Compass!");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Thank you for using Crisis Compass. Goodbye!");
                    System.exit(0); // Terminate the program immediately
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
