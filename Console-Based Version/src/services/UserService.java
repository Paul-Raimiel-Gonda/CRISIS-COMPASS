package services;

import models.User;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class for managing user-related operations.
 * Encapsulates business logic for user authentication, updates, and retrieval.
 */
public class UserService {

    // Simulating a user database using a HashMap for demonstration
    private Map<Integer, User> userDatabase;

    // Constructor initializes the user database
    public UserService() {
        userDatabase = new HashMap<>();
        initializeDummyUsers(); // Pre-load some sample data for testing
    }

    /**
     * Initializes the user database with dummy data.
     */
    private void initializeDummyUsers() {
        userDatabase.put(1, new User(1, "raim", "raim@example.com", "09123456789"));
        userDatabase.put(2, new User(2, "alex", "alex@example.com", "09987654321"));
    }

    /**
     * Authenticates a user by username.
     *
     * @param username the username provided by the user
     * @return the User object if found, null otherwise
     */
    public User authenticateUser(String username) {
        for (User user : userDatabase.values()) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Updates a user's contact information.
     *
     * @param userId       the ID of the user
     * @param newContact   the new contact number
     * @param newEmail     the new email address
     * @return true if the update was successful, false otherwise
     */
    public boolean updateUserDetails(int userId, String newContact, String newEmail) {
        User user = userDatabase.get(userId);
        if (user != null) {
            user.setContactNumber(newContact);
            user.setEmail(newEmail);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a user by ID.
     *
     * @param userId the ID of the user to retrieve
     * @return the User object if found, null otherwise
     */
    public User getUserById(int userId) {
        return userDatabase.get(userId);
    }

    /**
     * Displays all users for debugging or administrative purposes.
     */
    public void displayAllUsers() {
        for (User user : userDatabase.values()) {
            user.displayUserDetails();
            System.out.println("------");
        }
    }
}
