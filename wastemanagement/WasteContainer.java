package wastemanagement;

import java.util.UUID;

/**
 * Represents a waste container with specific type and capacity
 */
public class WasteContainer {
    private String id;
    private String type;
    private double capacity;
    private double currentFillLevel;
    
    public WasteContainer(String type, double capacity) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.type = type.toLowerCase();
        this.capacity = capacity;
        this.currentFillLevel = 0;
    }
    
    public boolean isFull() {
        return currentFillLevel >= capacity;
    }
    
    public void fill(double amount) {
        if (currentFillLevel + amount <= capacity) {
            currentFillLevel += amount;
        } else {
            currentFillLevel = capacity;
        }
    }
    
    public String getType() {
        return type;
    }
    
    public double getCapacity() {
        return capacity;
    }
    
    public double getCurrentFillLevel() {
        return currentFillLevel;
    }
    
    public String getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return String.format("Container[%s] Type: %s, Fill: %.1f/%.1f (%.0f%%)", 
            id, type, currentFillLevel, capacity, (currentFillLevel/capacity)*100);
    }
}