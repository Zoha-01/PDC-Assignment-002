public class OrderExecutionApp {
    public static void main(String[] args) {
        System.out.println("=== Starting Multi-Protocol Order Processor ===");

        OrderService fixService = new FIXOrderProcessor();
        OrderService restService = new RESTOrderProcessor();

        fixService.executeOrder("ORD_FIX_101", 250.50, 10);
        System.out.println("----------------------------------------------");
        restService.executeOrder("ORD_REST_202", 120.00, 5);
    }
}