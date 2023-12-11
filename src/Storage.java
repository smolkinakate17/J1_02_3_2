import java.util.ArrayList;
import java.util.List;


public class Storage {
    private String title;
    private String owner;

    public Storage(String title, String owner) {
        this.title = title;
        this.owner = owner;
    }


    public String getTitle() {
        return title;
    }

    public String getOwner() {
        return owner;
    }


    @Override
    public String toString() {
        return "Storage{" +
                "title='" + title + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
