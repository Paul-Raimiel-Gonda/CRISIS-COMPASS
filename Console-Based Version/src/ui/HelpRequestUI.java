package ui;

import services.HelpRequestService;
import models.HelpRequest;

import java.util.Scanner;

/**
 * Manages help request-related operations.
 */
public class HelpRequestUI {

    private final HelpRequestService helpRequestService;

    public HelpRequestUI() {
        helpRequestService = new HelpRequestService();
    }

    public void displayHelpRequestMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHelp Request Menu:");
        System.out.println("1. Create a Help Request");
        System.out.println("2. View My Requests");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> createHelpRequest();
            case 2 -> viewHelpRequests();
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void createHelpRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Describe your help request: ");
        String description = scanner.nextLine();

        HelpRequest request = new HelpRequest(0, username, description, HelpRequest.Status.PENDING);
        try {
            helpRequestService.createHelpRequest(request);
            System.out.println("Help request created successfully!");
        } catch (Exception e) {
            System.out.println("Error creating help request: " + e.getMessage());
        }
    }

    private void viewHelpRequests() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        try {
            var requests = helpRequestService.getHelpRequestsByUsername(username);
            if (requests.isEmpty()) {
                System.out.println("No help requests found.");
            } else {
                requests.forEach(HelpRequest::displayRequestDetails);
            }
        } catch (Exception e) {
            System.out.println("Error fetching help requests: " + e.getMessage());
        }
    }
}
