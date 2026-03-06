package wastemanagement;

/**
 * Concrete handler for organic waste
 */
public class OrganicWasteCollector extends WasteCollector {
    
    @Override
    public void collect(WasteContainer container) {
        if ("organic".equalsIgnoreCase(container.getType())) {
            System.out.println("🌱 Organic Waste Collector: Processing container " + container.getId());
            System.out.println("   Converting to compost...");
            System.out.println("   Container emptied and sanitized.");
        } else {
            System.out.println("   Organic Collector passing to next handler...");
            passToNext(container);
        }
    }
}