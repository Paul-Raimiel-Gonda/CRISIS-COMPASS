package ui;

import models.PredefinedInventoryItem;
import services.InventoryService;
import utils.ExceptionHandlingUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryUI {

    private final InventoryService inventoryService;

    public InventoryUI() {
        inventoryService = new InventoryService();
    }

    public void displayInventoryMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) { // Loop to allow returning to the main menu
            System.out.println("\nDISASTER INVENTORY:\n");
            System.out.println("1. Manage Inventory");
            System.out.println("2. View All Items");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> manageInventoryForDisaster();
                    case 2 -> viewAllItems();
                    case 3 -> {
                        System.out.println("Returning to Main Menu...");
                        return; // Return to Main Menu without recursive calls
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                ExceptionHandlingUtil.handleException(e);
                scanner.nextLine(); // Clear invalid input
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
            }
        }
    }

    private void manageInventoryForDisaster() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter disaster type \n(Typhoon, Flood, Earthquake, Volcanic Eruption, Drought): ");
        String disasterType = scanner.nextLine();

        List<PredefinedInventoryItem> allItems = inventoryService.getAllPredefinedItems();
        List<PredefinedInventoryItem> userSelectedItems = new ArrayList<>();

        if (allItems.isEmpty()) {
            System.out.println("No predefined items found in the inventory. Please check the database.");
            return;
        }

        System.out.println("\nAvailable Items:");
        int count = 0;
        for (PredefinedInventoryItem item : allItems) {
            System.out.printf("%-30s", "(" + item.getItemName() + ")");
            count++;
            if (count % 5 == 0) {
                System.out.println();
            }
        }
        if (count % 5 != 0) {
            System.out.println();
        }

        boolean addingItems = true;
        while (addingItems) {
            System.out.print("\nEnter the name of the item to add (or type 'done' to finish): ");
            String itemName = scanner.nextLine();
            if (itemName.equalsIgnoreCase("done")) {
                addingItems = false;
            } else {
                PredefinedInventoryItem selectedItem = allItems.stream()
                        .filter(item -> item.getItemName().equalsIgnoreCase(itemName))
                        .findFirst()
                        .orElse(null);
                if (selectedItem != null) {
                    userSelectedItems.add(selectedItem);
                    if (selectedItem.getApplicableDisasters().contains(disasterType)) {
                        System.out.println("Added: " + itemName + " (Essential for this disaster)");
                    } else {
                        System.out.println("Added: " + itemName + ". Note: This item is not essential for the selected disaster.");
                    }
                } else {
                    System.out.println("Item not found. Please try again.");
                }
            }
        }

        System.out.println("\nYour Inventory:");
        System.out.printf("%-30s %-15s %-10s\n", "Item Name", "Category", "Essential for Disaster Type");
        System.out.println("-----------------------------------------------------------------------------");
        for (PredefinedInventoryItem item : userSelectedItems) {
            boolean isCorrect = item.getApplicableDisasters().contains(disasterType);
            System.out.printf("%-30s %-15s %-10s\n", item.getItemName(), item.getCategory(), isCorrect ? "Yes" : "No");
        }

        List<PredefinedInventoryItem> missingItems = inventoryService.getMissingItemsByDisasterType(userSelectedItems, disasterType);
        if (!missingItems.isEmpty()) {
            System.out.println("\nTips:");
            StringBuilder tips = new StringBuilder("You're missing some essential items for this disaster. Here's why you need them:\n");
            for (PredefinedInventoryItem item : missingItems) {
                tips.append("- ").append(item.getItemName()).append(": ").append(item.getDescription()).append("\n");
            }
            System.out.println(tips);
        } else {
            System.out.println("\nGreat! You have all essential items for the selected disaster.");
        }
    }

    private void viewAllItems() {
        List<PredefinedInventoryItem> items = inventoryService.getAllPredefinedItems();
        if (items.isEmpty()) {
            System.out.println("No items found in the inventory.");
        } else {
            System.out.println("\nAll Inventory Items:");
            System.out.printf("%-5s %-30s %-15s %-70s %-10s\n", "ID", "Name", "Category", "Description", "Essential");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------");
            for (PredefinedInventoryItem item : items) {
                System.out.printf("%-5d %-30s %-15s %-70s %-10s\n",
                        item.getItemId(), item.getItemName(), item.getCategory(), item.getDescription(),
                        item.isEssential() ? "Yes" : "No");
            }
        }
    }
}
