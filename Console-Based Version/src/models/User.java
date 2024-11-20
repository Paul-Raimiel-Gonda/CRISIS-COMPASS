package models;

/**
 * Represents a user in the system with basic details.
 * Demonstrates encapsulation and sets a foundation for inheritance and polymorphism.
 */
public class User {

    // Encapsulated fields
    protected int userId; // Protected to allow access in subclasses
    protected String username;
    protected String email;
    protected String contactNumber;

    // Constructor
    public User(int userId, String username, String email, String contactNumber) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    // Getters and setters to maintain encapsulation
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Displays user details (Example of polymorphism for potential overriding).
     */
    public void displayUserDetails() {
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Contact Number: " + contactNumber);
    }
}
