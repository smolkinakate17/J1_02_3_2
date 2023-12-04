import java.util.ArrayList;
import java.util.List;


public class Storage {
    private String title;
    private String owner;
    private List<Item> items = new ArrayList<>();

    public Storage(String title, String owner) {
        this.title = title;
        this.owner = owner;
    }

    public Storage(String title, String owner, List<Item> items) {
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

    public List<Item> getItems() {
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
