package database;

import model.Discount;
import model.Product;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test(expected = DataBaseException.class)
    public void getProductInEmptyDataBase() {
        Database emptyDatabase = new Database();

        emptyDatabase.getProduct(2);
        emptyDatabase.getDiscount(2);
    }

    @Test(expected = DataBaseException.class)
    public void getNoExistingValueInDataBase() {
        Map<Integer, Product> initialProducts = new HashMap<>();
        initialProducts.put(1, new Product(2, "Banana", 4));
        initialProducts.put(2, new Product(9, "Cherry", 10));
        initialProducts.put(3, new Product(5, "Grape", 6));

        Map<Integer, Discount> initialDiscount = new HashMap<>();
        initialDiscount.put(1, new Discount(1, 3, "Alex"));
        initialDiscount.put(2, new Discount(2, 8, "Egor"));
        initialDiscount.put(3, new Discount(3, 4, "Victor"));

        Database database = new Database(initialProducts, initialDiscount);

        database.getProduct(12);
        database.getDiscount(14);
    }

    @Test
    public void getExistingValueInDataBase() {
        Map<Integer, Product> initialProducts = new HashMap<>();
        initialProducts.put(1, new Product(2, "Banana", 4));
        initialProducts.put(2, new Product(9, "Cherry", 10));
        initialProducts.put(3, new Product(5, "Grape", 6));

        Map<Integer, Discount> initialDiscount = new HashMap<>();
        initialDiscount.put(1, new Discount(1, 3, "Alex"));
        initialDiscount.put(2, new Discount(2, 8, "Egor"));
        initialDiscount.put(3, new Discount(3, 4, "Victor"));


        Database database = new Database(initialProducts, initialDiscount);
        database.getProduct(2);
        database.getDiscount(3);
    }
}