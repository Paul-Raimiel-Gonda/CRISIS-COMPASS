package models;

//CLASS FOR HELP REQUESTS
public class HelpRequest {

    public enum Status {
        PENDING, IN_PROGRESS, RESOLVED
    }

    private final int requestId;
    private final int userId;
    private String username; // Optional for display
    private final String disasterType;
    private String description;
    private Status status;

    // Constructor for displaying help requests
    public HelpRequest(int requestId, String username, String disasterType, String description, Status status) {
        this.requestId = requestId;
        this.userId = 0; // Placeholder
        this.username = username;
        this.disasterType = disasterType;
        this.description = description;
        this.status = status;
    }

    // Constructor for database use
    public HelpRequest(int requestId, int userId, String disasterType, String description, Status status) {
        this.requestId = requestId;
        this.userId = userId;
        this.disasterType = disasterType;
        this.description = description;
        this.status = status;
    }

    // Getters
    public int getRequestId() {
        return requestId;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    // Setters (if necessary)
    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
