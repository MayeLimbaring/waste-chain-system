package wastemanagement;

/**
 * Concrete handler for hazardous waste
 */
public class HazardousWasteCollector extends WasteCollector {
    
    @Override
    public void collect(WasteContainer container) {
        if ("hazardous".equalsIgnoreCase(container.getType())) {
            System.out.println("⚠️ Hazardous Waste Collector: Processing container " + container.getId());
            System.out.println("   Activating safety protocols...");
            System.out.println("   Special handling required for disposal.");
            System.out.println("   Container sterilized and secured.");
        } else {
            System.out.println("   Hazardous Collector passing to next handler...");
            passToNext(container);
        }
    }
}