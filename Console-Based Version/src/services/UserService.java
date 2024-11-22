package services;

import models.User;
import utils.HashingUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Service class to handle user-related operations like registration and login.
 */
public class UserService {

    // Encapsulated user database simulation (can be replaced by real DB logic)
    private final Map<String, User> userDatabase;

    /**
     * Constructor initializes the in-memory user database.
     */
    public UserService() {
        userDatabase = new HashMap<>();
        initializeDummyUsers(); // Add sample users
    }

    /**
     * Adds dummy users for testing purposes.
     */
    private void initializeDummyUsers() {
        userDatabase.put("testuser", new User("testuser", "password123", "Test User", "test@example.com", "Metro Manila"));
    }

    /**
     * Registers a new user.
     *
     * @param username The desired username.
     * @param password The plain-text password.
     * @param fullName The user's full name.
     * @param email    The user's email address.
     * @param location The user's location.
     * @return True if registration is successful, false if the username already exists.
     */
    public boolean register(String username, String password, String fullName, String email, String location) {
        if (userDatabase.containsKey(username)) {
            return false; // Username already exists
        }
        String hashedPassword = HashingUtils.hashPassword(password);
        userDatabase.put(username, new User(username, hashedPassword, fullName, email, location));
        return true;
    }

    /**
     * Logs in an existing user.
     *
     * @param username The username.
     * @param password The plain-text password.
     * @return The logged-in User object or null if login fails.
     */
    public User login(String username, String password) {
        User user = userDatabase.get(username);
        if (user != null && HashingUtils.comparePassword(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    /**
     * Displays all registered users (for debugging purposes).
     */
    public void displayAllUsers() {
        for (User user : userDatabase.values()) {
            System.out.println(user);
        }
    }
}
