package ui;

import services.HelpRequestService;
import models.HelpRequest;

import java.util.List;
import java.util.Scanner;

/**
 * Handles user interactions for help requests.
 */
public class HelpRequestUI {

    private final HelpRequestService helpRequestService;

    public HelpRequestUI() {
        helpRequestService = new HelpRequestService();
    }

    public void displayHelpRequestMenu(int currentUserId) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHelp Request Menu:");

            // Display ongoing help requests for all users
            displayOngoingHelpRequests();

            // Menu options
            System.out.println("\n1. Add a Help Request");
            System.out.println("2. View My Help Requests");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addHelpRequest(currentUserId);
                case 2 -> viewOwnHelpRequests(currentUserId);
                case 3 -> {
                    return; // Exit to Main Menu
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayOngoingHelpRequests() {
        System.out.println("\nOngoing Help Requests (excluding 'Resolved'):");
        List<HelpRequest> requests = helpRequestService.getOngoingHelpRequests();

        if (requests.isEmpty()) {
            System.out.println("No ongoing help requests found.");
        } else {
            // Display a table with ongoing help requests
            System.out.printf("%-10s %-15s %-20s %-30s %-10s%n",
                    "Request ID", "User", "Disaster Type", "Request Details", "Status");
            requests.forEach(request -> System.out.printf("%-10d %-15s %-20s %-30s %-10s%n",
                    request.getRequestId(), request.getUsername(), request.getDisasterType(),
                    request.getDescription(), request.getStatus()));
        }
    }

    private void addHelpRequest(int currentUserId) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAdd a Help Request:");
        System.out.print("Enter the disaster type: ");
        String disasterType = scanner.nextLine();
        System.out.print("Enter the request details: ");
        String requestDetails = scanner.nextLine();

        HelpRequest newRequest = new HelpRequest(0, currentUserId, disasterType, requestDetails, HelpRequest.Status.PENDING);
        helpRequestService.createHelpRequest(newRequest);
        System.out.println("Help request added successfully!");
    }

    private void viewOwnHelpRequests(int currentUserId) {
        Scanner scanner = new Scanner(System.in);
        List<HelpRequest> requests = helpRequestService.getHelpRequestsByUserId(currentUserId);

        if (requests.isEmpty()) {
            System.out.println("You have no help requests.");
            return;
        }

        System.out.println("\nYour Help Requests:");
        System.out.printf("%-10s %-20s %-30s %-10s%n",
                "Request ID", "Disaster Type", "Request Details", "Status");
        requests.forEach(request -> System.out.printf("%-10d %-20s %-30s %-10s%n",
                request.getRequestId(), request.getDisasterType(), request.getDescription(), request.getStatus()));

        System.out.println("\n1. Edit a Request");
        System.out.println("2. Set a Request to Resolved");
        System.out.println("3. Back");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> editHelpRequest(currentUserId);
            case 2 -> resolveHelpRequest(currentUserId);
            case 3 -> {
            }
            default -> System.out.println("Invalid choice. Returning to menu.");
        }
    }

    private void editHelpRequest(int currentUserId) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Request ID to edit: ");
        int requestId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the new request details: ");
        String newDetails = scanner.nextLine();

        boolean success = helpRequestService.updateHelpRequestDetails(requestId, newDetails, currentUserId);
        if (success) {
            System.out.println("Help request updated successfully!");
        } else {
            System.out.println("Failed to update help request. Please ensure you selected your own request.");
        }
    }

    private void resolveHelpRequest(int currentUserId) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Request ID to resolve: ");
        int requestId = scanner.nextInt();

        boolean success = helpRequestService.updateHelpRequestStatus(requestId, HelpRequest.Status.RESOLVED, currentUserId);
        if (success) {
            System.out.println("Help request marked as resolved!");
        } else {
            System.out.println("Failed to resolve help request. Please ensure you selected your own request.");
        }
    }
}
