import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements GenericRepository<String> {
    private final List<String> storage = new ArrayList<>();

    @Override
    public void add(String item) {
        storage.add(item);
        System.out.println("[REPOSITORY] Added item: " + item);
    }

    @Override
    public List<String> getAll() {
        return storage;
    }
}