import java.util.HashMap;
import java.util.Map;

public class Storage {
    private String title;
    private String owner;
    private Map<Item, Integer> items = new HashMap<>();

    public Storage(String title, String owner) {
        this.title = title;
        this.owner = owner;
    }

    public Storage(String title, String owner, Map<Item, Integer> items) {
        this.title = title;
        this.owner = owner;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "title='" + title + '\'' +
                ", owner='" + owner + '\'' +
                ", items=" + items +
                '}';
    }
}
