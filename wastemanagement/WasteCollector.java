package wastemanagement;

/**
 * Abstract handler in the Chain of Responsibility pattern
 */
public abstract class WasteCollector {
    protected WasteCollector nextCollector;
    
    public void setNextCollector(WasteCollector collector) {
        this.nextCollector = collector;
    }
    
    public abstract void collect(WasteContainer container);
    
    protected void passToNext(WasteContainer container) {
        if (nextCollector != null) {
            nextCollector.collect(container);
        } else {
            System.out.println("⚠️ No collector available for container type: " + container.getType());
        }
    }
}