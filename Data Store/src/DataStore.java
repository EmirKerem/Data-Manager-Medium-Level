import java.util.ArrayList;
import java.util.List;

public class DataStore<E> {
    private List<E> items;

    public DataStore() {
        items = new ArrayList<>();
    } 

    public void add_data(E item) {
        items.add(item);
        System.out.println(item + " added.");
    }

    public void remove_data(E item) {
        if (items.remove(item)) {
            System.out.println(item + " removed.");
        } else {
            System.out.println(item + " not found.");
        }
    }

    public void print_data() {
        if (items.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Data:");
            for (E item : items) {
                System.out.println(item);
            }
        }
    }
}
