import java.util.LinkedList;
import java.util.Queue;

public class SharedOrderBuffer {
    private final Queue<String> buffer = new LinkedList<>();
    private final int capacity;

    public SharedOrderBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(String order) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(order);
        System.out.println("[PRODUCER] Added: " + order);
        notifyAll();
    }

    public synchronized String consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        String order = buffer.poll();
        System.out.println("[CONSUMER] Processed: " + order);
        notifyAll();
        return order;
    }
}