public class TradeStreamProcessor implements Runnable {
    private final SharedOrderBuffer buffer;
    private final boolean isProducer;

    public TradeStreamProcessor(SharedOrderBuffer buffer, boolean isProducer) {
        this.buffer = buffer;
        this.isProducer = isProducer;
    }

    @Override
    public void run() {
        try {
            if (isProducer) {
                for (int i = 1; i <= 3; i++) {
                    buffer.produce("ORDER_#" + i);
                    Thread.sleep(200);
                }
            } else {
                for (int i = 1; i <= 3; i++) {
                    buffer.consume();
                    Thread.sleep(400);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}