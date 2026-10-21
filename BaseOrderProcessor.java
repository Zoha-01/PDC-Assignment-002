public abstract class BaseOrderProcessor implements OrderService {
    protected String protocolName;

    public BaseOrderProcessor(String protocolName) {
        this.protocolName = protocolName;
    }

    @Override
    public void validateOrder(String orderId) {
        System.out.println("[" + protocolName + "] Validating protocol headers for Order: " + orderId);
    }

    @Override
    public void logAuditTrail(String orderId, String status) {
        System.out.println("[" + protocolName + " AUDIT] Order ID: " + orderId + " | Status: " + status);
    }
}