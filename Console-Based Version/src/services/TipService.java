package services;

import disasters.*;
import models.DisasterTip;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for managing disaster tips.
 * Combines database-driven tip management and disaster-specific logic.
 */
public class TipService {

    // Encapsulated list of disaster tips (mimics database representation)
    private final List<DisasterTip> tips;

    // Disaster registry for dynamic tip retrieval
    private final Map<String, Disaster> disasterRegistry;

    /**
     * Constructor initializes tips and disaster-specific registry.
     */
    public TipService() {
        this.tips = new ArrayList<>();
        this.disasterRegistry = new HashMap<>();
        loadSampleTips(); // Load example tips
        registerDisasters(); // Register disaster objects
    }

    /**
     * Populates the list of disaster tips with sample data for testing.
     */
    private void loadSampleTips() {
        tips.add(new DisasterTip(1, "Flood", DisasterTip.TipCategory.BEFORE, "Prepare an emergency kit with food, water, and first aid supplies."));
        tips.add(new DisasterTip(2, "Flood", DisasterTip.TipCategory.DURING, "Move to higher ground and avoid wading through floodwaters."));
        tips.add(new DisasterTip(3, "Earthquake", DisasterTip.TipCategory.BEFORE, "Secure heavy furniture and create an emergency plan."));
        tips.add(new DisasterTip(4, "Earthquake", DisasterTip.TipCategory.DURING, "Drop, cover, and hold on to protect yourself from falling debris."));
        tips.add(new DisasterTip(5, "Typhoon", DisasterTip.TipCategory.AFTER, "Stay tuned to local news for updates and avoid flooded areas."));
    }

    /**
     * Registers disaster types and their corresponding logic objects.
     */
    private void registerDisasters() {
        disasterRegistry.put("Flood", new Flood());
        disasterRegistry.put("Earthquake", new Earthquake());
        disasterRegistry.put("Volcanic Eruption", new VolcanicEruption());
        disasterRegistry.put("Drought", new Drought());
        disasterRegistry.put("Typhoon", new Typhoon());
    }

    /**
     * Retrieves tips for a specific disaster and category from the database representation.
     *
     * @param disasterType The type of disaster (e.g., "Flood", "Earthquake").
     * @param category     The tip category (e.g., BEFORE, DURING, AFTER, EMERGENCY).
     * @return A list of tips matching the criteria, or an empty list if no tips are found.
     */
    public List<DisasterTip> getTipsByDisasterAndCategory(String disasterType, DisasterTip.TipCategory category) {
        return tips.stream()
                .filter(tip -> tip.getDisasterType().equalsIgnoreCase(disasterType) && tip.getCategory() == category)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves general preparedness tips for a disaster type using disaster-specific logic.
     *
     * @param disasterType The type of disaster (e.g., "Flood", "Earthquake").
     * @return A string of general preparedness tips, or a default message if the disaster is not found.
     */
    public String getDisasterPreparednessTips(String disasterType) {
        Disaster disaster = disasterRegistry.get(disasterType);
        if (disaster != null) {
            return String.join("\n", disaster.getGeneralTips());
        }
        return "No specific tips available for this disaster type.";
    }

    /**
     * Adds a new disaster tip to the list, simulating database update functionality.
     *
     * @param tip The DisasterTip object to add.
     */
    public void addTip(DisasterTip tip) {
        tips.add(tip);
    }

    /**
     * Displays all stored tips for debugging or administrative purposes.
     */
    public void displayAllTips() {
        tips.forEach(DisasterTip::displayTipDetails);
    }

    /**
     * Returns a formatted list of all supported disaster types.
     *
     * @return A string listing all disaster types.
     */
    public String getAvailableDisasterTypes() {
        return String.join(", ", disasterRegistry.keySet());
    }

    /**
     * Retrieves disaster-specific tips by disaster type.
     * Includes both database tips and general preparedness tips.
     *
     * @param disasterType The disaster type (e.g., "Flood").
     * @return A formatted string combining specific and general tips.
     */
    public String getAllTipsForDisaster(String disasterType) {
        StringBuilder result = new StringBuilder();
        List<DisasterTip> categoryTips = tips.stream()
                .filter(tip -> tip.getDisasterType().equalsIgnoreCase(disasterType))
                .collect(Collectors.toList());

        if (!categoryTips.isEmpty()) {
            result.append("Database Tips:\n");
            categoryTips.forEach(tip -> result.append("- ").append(tip.getCategory()).append(": ").append(tip.getTip()).append("\n"));
        } else {
            result.append("No database tips available for this disaster type.\n");
        }

        String generalTips = getDisasterPreparednessTips(disasterType);
        if (!generalTips.equals("No specific tips available for this disaster type.")) {
            result.append("\nGeneral Preparedness Tips:\n").append(generalTips);
        }

        return result.toString().trim();
    }
}
