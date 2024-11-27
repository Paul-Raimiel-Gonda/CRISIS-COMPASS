package models;

import java.time.LocalDateTime;

/**
 * Represents a help request in the system.
 * Includes details like the username, request description, status, and timestamp.
 */
public class HelpRequest {

    // Enum to represent the status of a help request
    public enum Status {
        PENDING, IN_PROGRESS, RESOLVED
    }

    private final int requestId; // Unique identifier for the request
    private final String username; // User who submitted the request
    private final String description; // Description of the request
    private Status status; // Current status of the request
    private final LocalDateTime timestamp; // Time the request was created

    /**
     * Constructor for HelpRequest.
     *
     * @param requestId   The unique ID for the request.
     * @param username    The username of the requester.
     * @param description The description of the help request.
     * @param status      The initial status of the request.
     */
    public HelpRequest(int requestId, String username, String description, Status status) {
        this.requestId = requestId;
        this.username = username;
        this.description = description;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and setters for encapsulation

    public int getRequestId() {
        return requestId;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Displays the details of the help request.
     */
    public void displayRequestDetails() {
        System.out.println("Request ID: " + requestId);
        System.out.println("Username: " + username);
        System.out.println("Description: " + description);
        System.out.println("Status: " + status);
        System.out.println("Timestamp: " + timestamp);
    }
}
