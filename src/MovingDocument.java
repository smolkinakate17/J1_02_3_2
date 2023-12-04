import java.util.Date;


public class MovingDocument extends ShipmentDocument {
    Storage movingStorage;

    public MovingDocument(String documentId, Date documentDate, Storage storage, Storage movingStorage) {
        super(documentId, documentDate, storage);
        this.movingStorage = movingStorage;
    }

    /**
     * Суммарная стоимость товаров, попадающих в список промо-акции.
     */
    public double promoSum(String[] promoArticles) {
        long sum = 0;
        for (String art : promoArticles) {
            Item item = findEntryItemIntegerByArticle(art);
            if (item == null) {
                continue;
            }
            int itemPriceInKopeck = (int) (item.getPrice() * 100);

            sum += item.getQuantity() * (long) itemPriceInKopeck;
        }
        return (double) sum / 100;
    }

    /**
     * Является ли перемещение внутренним (между складами одного владельца).
     * Для продаж неприменимо!
     */
    public boolean isInternalMovement() {
        return movingStorage.getOwner().equals(storage.getOwner());
    }

}
