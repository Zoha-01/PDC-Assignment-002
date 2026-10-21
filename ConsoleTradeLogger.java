public class ConsoleTradeLogger implements TradeLogger {
    @Override
    public void logInfo(String message) {
        System.out.println("[INFO] " + message);
    }

    @Override
    public void logError(String errorCode, String errorMessage) {
        System.err.println("[ERROR - " + errorCode + "] " + errorMessage);
    }
}