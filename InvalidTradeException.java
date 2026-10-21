public class InvalidTradeException extends Exception {
    private String errorCode;

    public InvalidTradeException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}