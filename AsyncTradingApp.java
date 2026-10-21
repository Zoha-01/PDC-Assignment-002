public class AsyncTradingApp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Starting Asynchronous Order Processing Pipeline ===");
        
        SharedOrderBuffer buffer = new SharedOrderBuffer(2);

        Thread producerThread = new Thread(new TradeStreamProcessor(buffer, true));
        Thread consumerThread = new Thread(new TradeStreamProcessor(buffer, false));

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("=== Pipeline Finished Successfully ===");
    }
}