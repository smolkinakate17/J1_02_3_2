import java.util.Objects;


public class Item {
    private String id;
    private String article;
    private String title;
    private double price;
    private int quantity;


    public Item(String id, String article, String title, double price, int quantity) {
        this.id = id;
        this.article = article;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
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
                "id='" + id + '\'' +
                ", article='" + article + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
