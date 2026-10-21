public class FIXOrderProcessor extends BaseOrderProcessor {
    public FIXOrderProcessor() {
        super("FIX Protocol v4.4");
    }

    @Override
    public void executeOrder(String orderId, double price, int quantity) {
        validateOrder(orderId);
        double totalValue = price * quantity;
        System.out.println("[FIX Engine] Executing FIX Tag 35=D | Order: " + orderId + " | Total: $" + totalValue);
        logAuditTrail(orderId, "EXECUTED_VIA_FIX");
    }
}