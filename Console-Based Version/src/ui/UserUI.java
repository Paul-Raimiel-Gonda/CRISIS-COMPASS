package ui;

import database.DatabaseConnection;
import models.User;
import services.UserService;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;
import java.util.Scanner;

public class UserUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService;

    static {
        try {
            userService = new UserService(DatabaseConnection.getInstance().getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Method for user registration
    public static void registerUser() {
        System.out.println("Please enter your details to register:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();

        // Hash the password using BCrypt
        String passwordHash = hashPassword(password);

        if (userService.createUser(username, passwordHash, email, contactNumber)) {
            System.out.println("Registration successful! You can now log in.");
        } else {
            System.out.println("Registration failed. Please try again.");
        }
    }

    // Method for user login
    public static int loginUser() {
        System.out.println("Login to your account:");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Fetch user from database
        User user = userService.getUserByUsername(username);

        if (user == null) {
            System.out.println("Invalid username or password. Please try again.");
            return -1; // Indicates login failure
        } else {
            // Verify the entered password against the stored hashed password
            if (checkPassword(password, user.getPasswordHash())) {
                System.out.println("Login successful! Welcome, " + user.getUsername() + ".");
                return user.getUserId(); // Return the user's ID after successful login
            } else {
                System.out.println("Invalid username or password. Please try again.");
                return -1; // Indicates login failure
            }
        }
    }

    // Method to display the user registration or login menu
    public static int showUserMenu() {
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
                    int userId = loginUser(); // Attempt login
                    if (userId != -1) {
                        return userId; // Return logged-in user's ID
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using Crisis Compass. Goodbye!");
                    System.exit(0); // Terminate the program immediately
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Utility method to hash passwords using BCrypt
    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Utility method to check if the entered password matches the hashed password
    private static boolean checkPassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
}
