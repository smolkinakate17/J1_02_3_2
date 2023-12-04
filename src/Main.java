import java.time.Instant;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();

        Storage firstStorage = new Storage("FirstStorage", "FirstStorageOwner");
        for (int i = 0; i < 10; i++) {
            Item item = new Item(UUID.randomUUID().toString(), String.valueOf(rnd.nextInt(100000000, 999999999)), i + "Item", rnd.nextDouble(100.0, 9000.0), rnd.nextInt(100, 1000));
            firstStorage.getItems().add(item);
        }
        Item i1 = new Item(UUID.randomUUID().toString(), String.valueOf(rnd.nextInt(100000000, 999999999)), "Item1", rnd.nextDouble(100.0, 9000.0), rnd.nextInt(100, 1000));
        firstStorage.getItems().add(i1);
        SaleDocument firstSale = new SaleDocument(UUID.randomUUID().toString(), Date.from(Instant.now()), firstStorage, "Customer");

        Storage secondStorage = new Storage("SecondStorage", "SecondStorageOwner");
        for (int i = 0; i < 10; i++) {
            Item item = new Item(UUID.randomUUID().toString(), String.valueOf(rnd.nextInt(100000000, 999999999)), i + "Item", rnd.nextDouble(100.0, 9000.0), rnd.nextInt(100, 1000));
            secondStorage.getItems().add(item);
        }
        Item i2 = new Item(UUID.randomUUID().toString(), String.valueOf(rnd.nextInt(100000000, 999999999)), "Item1", rnd.nextDouble(100.0, 9000.0), rnd.nextInt(100, 1000));
        secondStorage.getItems().add(i2);

        Storage thirdStorage = new Storage("ThirdStorage", "SecondStorageOwner");
        Storage fourthStorage = new Storage("FourthStorage", "FourthStorageOwner");

        MovingDocument firstMoving = new MovingDocument(UUID.randomUUID().toString(), Date.from(Instant.now()), secondStorage, thirdStorage);
        MovingDocument secondMoving = new MovingDocument(UUID.randomUUID().toString(), Date.from(Instant.now()), secondStorage, fourthStorage);

        System.out.println("Суммарная стоимость товаров в документе firstSale = " + firstSale.totalAmount());
        System.out.println("Суммарная стоимость товаров в документе firstMoving = " + firstMoving.totalAmount());
        System.out.println("Стоимость товара с id = " + i1.getId() + " = " + firstSale.itemAmount(i1.getId()));
        System.out.println("Стоимость товара с id = " + i2.getId() + " = " + firstMoving.itemAmount(i2.getId()));
        System.out.println("Является ли перемещение внутренним для firstMoving " + firstMoving.isInternalMovement());
        System.out.println("Является ли перемещение внутренним для secondMoving " + secondMoving.isInternalMovement());
        System.out.println("Суммарная стоимость товаров, попадающих в список промо-акции " + firstSale.promoSum(new String[]{"1", i1.getArticle()}, 10));
        System.out.println("Суммарная стоимость товаров, попадающих в список промо-акции " + firstMoving.promoSum(new String[]{"2", i2.getArticle()}));
        System.out.println("Является ли продажа оптовой для объема=1000 " + firstSale.isWholesale(1000));
        System.out.println(firstSale);
        System.out.println(firstMoving);

    }
}