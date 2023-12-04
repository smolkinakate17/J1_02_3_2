import java.util.*;

/**
 * Документ отгрузки со склада.
 * Бывает двух типов: перемещение (на другой склад) и продажа (покупателю).
 */
public class ShipmentDocument {
    protected String documentId;
    protected Date documentDate;
    protected Storage storage;


    public ShipmentDocument(String documentId, Date documentDate, Storage storage) {
        this.documentId = documentId;
        this.documentDate = documentDate;
        this.storage = storage;
    }

    /**
     * Суммарная стоимость товаров в документе.
     */

    public double totalAmount() {
        long sum = 0;
        for (Item item : storage.getItems()) {
            int kopeckPrice = (int) (item.getPrice() * 100);
            sum += item.getQuantity() * (long) kopeckPrice;
        }
        return (double) sum / 100;
    }

    /**
     * Стоимость товара с переданным id.
     */
    public double itemAmount(String id) {
        Item item = storage.getItems().stream().filter(item1 -> item1.getId().equals(id)).findFirst().orElse(null);
        if (item == null) {
            return 0;
        }
        int kopeckPrice = (int) (item.getPrice() * 100);
        return (double) (item.getQuantity() * kopeckPrice) / 100;
    }


    /**
     * Item с переданным article.
     */
    protected Item findEntryItemIntegerByArticle(String article) {
        return storage.getItems().stream().filter(item -> item.getArticle().equals(article)).findFirst().orElse(null);
    }

    public String getDocumentId() {
        return documentId;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public Storage getStorage() {
        return storage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipmentDocument that)) return false;
        return getDocumentId().equals(that.getDocumentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocumentId());
    }

    @Override
    public String toString() {
        return "ShipmentDocument{" +
                "documentId='" + documentId + '\'' +
                ", documentDate=" + documentDate +
                ", storage=" + storage +
                '}';
    }
}