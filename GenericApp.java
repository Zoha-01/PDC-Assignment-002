public class GenericApp {
    public static void main(String[] args) {
        System.out.println("=== Starting Generic Repository Testing Engine ===");

        GenericRepository<String> repository = new OrderRepository();

        // Add items
        repository.add("ORDER_1001_AAPL");
        repository.add("ORDER_1002_TSLA");
        repository.add("ORDER_1003_MSFT");

        System.out.println("---------------------------------------------");
        System.out.println("All Stored Orders: " + repository.getAll());

        // Find item
        System.out.println("---------------------------------------------");
        String found = repository.findById("1002");
        System.out.println("[QUERY] Searching for 1002 -> Found: " + found);

        // Delete item
        repository.delete("1001");
        System.out.println("Updated Stored Orders: " + repository.getAll());

        System.out.println("=== Generic Repository Operations Complete ===");
    }
}