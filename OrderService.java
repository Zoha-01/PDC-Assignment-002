public interface OrderService {
    void validateOrder(String orderId);
    void executeOrder(String orderId, double price, int quantity);
    void logAuditTrail(String orderId, String status);
}