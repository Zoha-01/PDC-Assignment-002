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

    @Override
    public String findById(String id) {
        for (String item : storage) {
            if (item.contains(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        String item = findById(id);
        if (item != null) {
            storage.remove(item);
            System.out.println("[REPOSITORY] Deleted item with ID: " + id);
        }
    }
}