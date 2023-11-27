import java.util.Date;
import java.util.Map;

public class MovingDocument extends ShipmentDocument {
    public MovingDocument(String documentId, Date documentDate, Storage storage) {
        super(documentId, documentDate, storage);
    }

    /**
     * Суммарная стоимость товаров, попадающих в список промо-акции.
     */
    public double promoSum(String[] promoArticles) {
        long sum = 0;
        for (String art : promoArticles) {
            Map.Entry<Item, Integer> item = findEntryItemIntegerByArticle(art);
            if(item==null){
                continue;
            }
            int itemPriceInKopeck = (int) (item.getKey().getPrice() * 100);

            sum += item.getValue() * (long)itemPriceInKopeck;
        }
        return (double) sum/100;
    }

}
