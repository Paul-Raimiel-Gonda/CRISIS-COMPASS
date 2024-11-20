package models;

import java.time.LocalDateTime;

/**
 * Represents a help request submitted by a user.
 * Demonstrates encapsulation and sets a foundation for future integration with the database.
 */
public class HelpRequest {

    // Encapsulated fields
    private int requestId;
    private int userId; // Foreign key reference to User
    private String disasterType; // Example: "Flood", "Earthquake"
    private String description;
    private String status; // Example: "Pending", "In Progress", "Resolved"
    private LocalDateTime dateSubmitted;

    // Constructor
    public HelpRequest(int requestId, int userId, String disasterType, String description, String status, LocalDateTime dateSubmitted) {
        this.requestId = requestId;
        this.userId = userId;
        this.disasterType = disasterType;
        this.description = description;
        this.status = status;
        this.dateSubmitted = dateSubmitted;
    }

    // Getters and setters for encapsulation
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public void setDisasterType(String disasterType) {
        this.disasterType = disasterType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(LocalDateTime dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    /**
     * Displays the help request details.
     */
    public void displayRequestDetails() {
        System.out.println("Request ID: " + requestId);
        System.out.println("User ID: " + userId);
        System.out.println("Disaster Type: " + disasterType);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Date Submitted: " + dateSubmitted);
    }

    /**
     * Updates the status of the help request.
     *
     * @param newStatus the new status of the request
     */
    public void updateStatus(String newStatus) {
        System.out.println("Updating status from " + this.status + " to " + newStatus);
        this.status = newStatus;
    }
}
