import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class SaleDocument extends ShipmentDocument {
    private String customer; // получатель (только для продажи)

    public SaleDocument(String documentId, Date documentDate, Storage storage, String customer) {
        super(documentId, documentDate, storage);
        this.customer = customer;
    }

    /**
     * Суммарная стоимость товаров, попадающих в список промо-акции.
     */
    public double promoSum(String[] promoArticles, int discount) {
        long sum = 0;
        for (String art : promoArticles) {
            Map.Entry<Item, Integer> item = findEntryItemIntegerByArticle(art);
            if (item == null) {
                continue;
            }
            int itemPriceInKopeck = (int) (item.getKey().getPrice() * 100);
            double kopeckDiscount = itemPriceInKopeck * (double) discount / 100;
            double kopeckPriceWithDiscount = itemPriceInKopeck - kopeckDiscount;


            sum += Math.ceil(item.getValue() * kopeckPriceWithDiscount);
        }
        return (double) sum / 100;
    }

    /**
     * Является ли продажа оптовой для переданного минимального объема.
     * Для перемещений неприменимо!
     */
    public boolean isWholesale(double minQuantity) {

        double sumQuantity = 0;
        for (Map.Entry<Item, Integer> item : storage.getItems().entrySet()) {
            if (item.getValue() >= minQuantity) {
                return true;
            }
            sumQuantity += item.getValue();
            if (sumQuantity >= minQuantity) {
                return true;
            }
        }
        return sumQuantity >= minQuantity;
    }

    public String getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "SaleDocument{" +
                "customer='" + customer + '\'' +
                ", documentId='" + documentId + '\'' +
                ", documentDate=" + documentDate +
                ", storage=" + storage +
                '}';
    }
}
