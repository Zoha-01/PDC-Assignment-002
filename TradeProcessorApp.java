public class TradeProcessorApp {
    public static void validateTrade(double price, int volume) throws InvalidTradeException {
        if (price <= 0) {
            throw new InvalidTradeException("Trade price must be strictly positive.", "ERR_INVALID_PRICE");
        }
        if (volume <= 0) {
            throw new InvalidTradeException("Trade volume must be greater than zero.", "ERR_INVALID_VOLUME");
        }
    }
}