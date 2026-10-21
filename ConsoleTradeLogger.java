public class ConsoleTradeLogger implements TradeLogger {
    @Override
    public void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }
}