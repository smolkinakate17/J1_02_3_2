import java.util.Objects;
import java.util.UUID;

public class Item {
    private String id;
    private String article;
    private String title;
    private double price;


    public Item(String id, String article, String title, double price) {
        this.id = id;
        this.article = article;
        this.title = title;
        this.price = price;
    }


    public String getId() {
        return id;
    }

    public String getArticle() {
        return article;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return getId().equals(item.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", article='" + article + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price + '\'' +
                '}';
    }


}
