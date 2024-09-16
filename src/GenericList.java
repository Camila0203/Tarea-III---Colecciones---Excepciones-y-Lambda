import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
    private List<T> list;

    public GenericList() {
        this.list = new ArrayList<>();
    }

    public void add(T item) {
        list.add(item);
    }

    public void remove(T item) {
        list.remove(item);
    }

    public T find(int id) {
        for (T item : list) {
            if (item instanceof Student && ((Student) item).getId() == id) {
                return item;
            }
        }
        return null;
    }

    public int size() {
        return list.size();
    }

    public List<T> getList() {
        return list;
    }
}
