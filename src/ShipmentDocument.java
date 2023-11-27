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
        for (Map.Entry<Item, Integer> item : storage.getItems().entrySet()) {
            int kopeckPrice = (int) (item.getKey().getPrice() * 100);
            sum += item.getValue() * (long) kopeckPrice;
        }
        return (double) sum / 100;
    }

    /**
     * Стоимость товара с переданным id.
     */
    public double itemAmount(String id) {
        Map.Entry<Item, Integer> item = storage.getItems().entrySet().stream().
                filter(itemIntegerEntry -> itemIntegerEntry.getKey().getId().equals(id)).
                findFirst().orElse(null);
        if (item == null) {
            return 0;
        }
        int kopeckPrice = (int) (item.getKey().getPrice() * 100);
        return (double) (item.getValue() * kopeckPrice) / 100;
    }

    /**
     * Является ли перемещение внутренним (между складами одного владельца).
     * Для продаж неприменимо!
     */
    public boolean isInternalMovement() {
        return this instanceof MovingDocument;
    }

    /**
     * Map.Entry<Item, Integer> с переданным article.
     */
    protected Map.Entry<Item, Integer> findEntryItemIntegerByArticle(String article) {
        return storage.getItems().entrySet().stream().
                filter(itemIntegerEntry -> itemIntegerEntry.getKey().getArticle().equals(article)).
                findFirst().orElse(null);
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