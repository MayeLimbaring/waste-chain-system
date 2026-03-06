package wastemanagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Main system that manages waste containers and collection process
 */
public class WasteManagementSystem {
    private WasteCollector collectionChain;
    private List<WasteContainer> containers;
    
    public WasteManagementSystem() {
        this.containers = new ArrayList<>();
        initializeChain();
    }
    
    private void initializeChain() {
        // Create collectors
        WasteCollector organicCollector = new OrganicWasteCollector();
        WasteCollector recyclableCollector = new RecyclableWasteCollector();
        WasteCollector hazardousCollector = new HazardousWasteCollector();
        
        // Build the chain: Organic -> Recyclable -> Hazardous
        organicCollector.setNextCollector(recyclableCollector);
        recyclableCollector.setNextCollector(hazardousCollector);
        
        this.collectionChain = organicCollector;
        
        System.out.println("✅ Waste collection chain initialized:");
        System.out.println("   Organic → Recyclable → Hazardous");
    }
    
    public void addContainer(WasteContainer container) {
        containers.add(container);
        System.out.println("📦 Added new container: " + container);
    }
    
    public void processContainers() {
        System.out.println("\n🔄 Starting waste collection process...");
        System.out.println("======================================");
        
        for (WasteContainer container : containers) {
            System.out.println("\n📋 Processing " + container);
            
            if (container.isFull()) {
                System.out.println("   Container is FULL - initiating collection...");
                collectionChain.collect(container);
                // Reset container after collection
                container.fill(-container.getCurrentFillLevel()); // Empty the container
                System.out.println("   ✅ Collection complete for container " + container.getId());
            } else {
                System.out.println("   Container not full yet. Fill level: " + 
                    (container.getCurrentFillLevel()/container.getCapacity()*100) + "%");
            }
        }
    }
    
    public void displaySystemStatus() {
        System.out.println("\n📊 System Status:");
        System.out.println("=================");
        for (WasteContainer container : containers) {
            System.out.println(container);
        }
    }
    
    public static void main(String[] args) {
        // Create the waste management system
        WasteManagementSystem system = new WasteManagementSystem();
        
        // Create different types of containers
        WasteContainer organic1 = new WasteContainer("organic", 100);
        WasteContainer recyclable1 = new WasteContainer("recyclable", 200);
        WasteContainer hazardous1 = new WasteContainer("hazardous", 50);
        WasteContainer unknown1 = new WasteContainer("electronic", 75);
        
        // Add containers to system
        system.addContainer(organic1);
        system.addContainer(recyclable1);
        system.addContainer(hazardous1);
        system.addContainer(unknown1);
        
        // Fill containers to trigger collection
        organic1.fill(100);  // Fill to capacity
        recyclable1.fill(150); // Not full
        hazardous1.fill(50);  // Fill to capacity
        
        // Process containers
        system.processContainers();
        
        // Display final status
        system.displaySystemStatus();
    }
}