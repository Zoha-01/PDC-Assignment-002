import java.util.List;

public interface GenericRepository<T> {
    void add(T item);
    List<T> getAll();
}