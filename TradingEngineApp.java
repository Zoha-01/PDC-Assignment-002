public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("=== CEP Engine Initialized ===");

        TradeEvent fixEvent = new FIXOrderEvent("FIX_GW_01", System.currentTimeMillis(), 1500.0, "ORD_99182");
        TradeEvent reutersEvent = new ReutersQuoteEvent("REUTERS_GW_02", System.currentTimeMillis(), 1500.0, 1498.50, 1502.25);

        fixEvent.dispatch();
        reutersEvent.dispatch();
    }
}