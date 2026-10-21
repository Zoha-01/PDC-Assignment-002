public class RESTOrderProcessor extends BaseOrderProcessor {
    public RESTOrderProcessor() {
        super("REST API Endpoint");
    }

    @Override
    public void executeOrder(String orderId, double price, int quantity) {
        validateOrder(orderId);
        double totalValue = price * quantity;
        System.out.println("[REST Gateway] Parsing JSON POST Payload | Order: " + orderId + " | Total: $" + totalValue);
        logAuditTrail(orderId, "EXECUTED_VIA_REST");
    }
}