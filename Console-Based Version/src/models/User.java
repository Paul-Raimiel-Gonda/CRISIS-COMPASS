package models;

public class User {

    private int userId;
    private String username;
    private String email;
    private String contactNumber;
    private String passwordHash;

    public User(int userId, String username, String email, String contactNumber, String passwordHash) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.contactNumber = contactNumber;
        this.passwordHash = passwordHash;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
