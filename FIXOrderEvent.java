public class FIXOrderEvent extends TradeEvent {
    private String clOrdId;

    public FIXOrderEvent(String senderId, long timestamp, double basePrice, String clOrdId) {
        super(senderId, timestamp, basePrice);
        this.clOrdId = clOrdId;
    }

    @Override
    public void dispatch() {
        double fee = basePrice * 0.0015;
        double totalPrice = basePrice + fee;
        System.out.println("[FIX Order] Client Order ID: " + clOrdId + " | Base: $" + basePrice + " | Fee (0.15%): $" + fee + " | Total: $" + totalPrice);
    }
}