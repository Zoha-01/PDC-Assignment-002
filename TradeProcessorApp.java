public class TradeProcessorApp {
    private static TradeLogger logger = new ConsoleTradeLogger();

    public static void validateTrade(double price, int volume) throws InvalidTradeException {
        if (price <= 0) {
            throw new InvalidTradeException("Trade price must be strictly positive.", "ERR_INVALID_PRICE");
        }
        if (volume <= 0) {
            throw new InvalidTradeException("Trade volume must be greater than zero.", "ERR_INVALID_VOLUME");
        }
    }

    public static void main(String[] args) {
        logger.logInfo("=== Initializing Trade Validation Engine ===");

        // Test Case 1: Valid Trade
        try {
            validateTrade(250.75, 100);
            logger.logInfo("Trade 1 Validated & Processed Successfully.");
        } catch (InvalidTradeException e) {
            logger.logError(e.getErrorCode(), e.getMessage());
        }

        // Test Case 2: Invalid Trade Exception Handling
        try {
            validateTrade(-10.0, 50);
        } catch (InvalidTradeException e) {
            logger.logError(e.getErrorCode(), e.getMessage());
        }
    }
}