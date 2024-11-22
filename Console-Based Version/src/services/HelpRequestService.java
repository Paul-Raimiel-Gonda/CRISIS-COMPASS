package services;

import models.HelpRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for managing help requests.
 */
public class HelpRequestService {

    // Encapsulated list of help requests
    private final List<HelpRequest> helpRequests;

    /**
     * Constructor initializes the help requests list.
     */
    public HelpRequestService() {
        helpRequests = new ArrayList<>();
    }

    /**
     * Submits a new help request.
     *
     * @param helpRequest The help request to add.
     */
    public void submitRequest(HelpRequest helpRequest) {
        helpRequests.add(helpRequest);
    }

    /**
     * Retrieves all pending help requests for a user.
     *
     * @param username The username of the requester.
     * @return A list of pending help requests.
     */
    public List<HelpRequest> getPendingRequests(String username) {
        return helpRequests.stream()
                .filter(req -> req.getUsername().equals(username) && req.getStatus() == HelpRequest.Status.PENDING)
                .collect(Collectors.toList());
    }

    /**
     * Updates the status of a help request.
     *
     * @param requestId The ID of the request to update.
     * @param newStatus The new status (IN_PROGRESS or RESOLVED).
     * @return True if updated successfully, false otherwise.
     */
    public boolean updateRequestStatus(int requestId, HelpRequest.Status newStatus) {
        for (HelpRequest req : helpRequests) {
            if (req.getRequestId() == requestId) {
                req.setStatus(newStatus);
                return true;
            }
        }
        return false;
    }

    /**
     * Displays all help requests (for debugging purposes).
     */
    public void displayAllRequests() {
        for (HelpRequest req : helpRequests) {
            req.displayRequestDetails();
            System.out.println("------");
        }
    }
}
