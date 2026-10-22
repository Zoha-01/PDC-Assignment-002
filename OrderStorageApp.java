import java.io.*;

// Serializable Model Class
class OrderRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String orderId;
    private double price;
    private int quantity;

    public OrderRecord(String orderId, double price, int quantity) {
        this.orderId = orderId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getOrderId() { return orderId; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "OrderRecord [ID=" + orderId + ", Price=$" + price + ", Qty=" + quantity + "]";
    }
}

// Main Driver Application
public class OrderStorageApp {
    private static final String FILE_NAME = "orders_data.ser";

    // Method to serialize object to file
    public static void saveOrder(OrderRecord order) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(order);
            System.out.println("[STORAGE] Order saved successfully: " + order.getOrderId());
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to save order: " + e.getMessage());
        }
    }

    // Method to deserialize object from file
    public static OrderRecord loadOrder() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            OrderRecord order = (OrderRecord) ois.readObject();
            System.out.println("[STORAGE] Order loaded successfully from file.");
            return order;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("[ERROR] Failed to load order: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Starting Order Storage System ===");

        // Step 1: Create and Save Object
        OrderRecord originalOrder = new OrderRecord("ORD_88219", 450.25, 20);
        saveOrder(originalOrder);

        System.out.println("------------------------------------");

        // Step 2: Read Object Back from File
        OrderRecord retrievedOrder = loadOrder();
        
        if (retrievedOrder != null) {
            System.out.println("[OUTPUT] Retrieved Data: " + retrievedOrder);
        }

        System.out.println("=== Storage Operations Completed ===");
    }
}