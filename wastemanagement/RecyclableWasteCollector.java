package wastemanagement;

/**
 * Concrete handler for recyclable waste
 */
public class RecyclableWasteCollector extends WasteCollector {
    
    @Override
    public void collect(WasteContainer container) {
        if ("recyclable".equalsIgnoreCase(container.getType())) {
            System.out.println("♻️ Recyclable Waste Collector: Processing container " + container.getId());
            System.out.println("   Sorting materials...");
            System.out.println("   Preparing for recycling process.");
        } else {
            System.out.println("   Recyclable Collector passing to next handler...");
            passToNext(container);
        }
    }
}