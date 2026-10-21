public interface TradeLogger {
    void logInfo(String message);
    void logError(String errorCode, String errorMessage);
}