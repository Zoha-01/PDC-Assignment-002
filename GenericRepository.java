import java.util.List;

public interface GenericRepository<T> {
    void add(T item);
    List<T> getAll();
    T findById(String id);
    void delete(String id);
}