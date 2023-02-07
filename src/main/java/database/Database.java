package database;

import model.Discount;
import model.Product;

import java.util.Map;
import java.util.Objects;

public class Database {
    private final Storage<Product> productStorage;
    private final Storage<Discount> discountStorage;

    public Database(Map<Integer, Product> initialProducts, Map<Integer, Discount> initialDiscounts) {
        productStorage = new Storage<>(initialProducts);
        discountStorage = new Storage<>(initialDiscounts);
    }

    public Database() {
        productStorage = new Storage<>();
        discountStorage = new Storage<>();
    }

    public Product getProduct(int id) {
        Product value = productStorage.getValue(id);
        if (value == null) {
            throw new DataBaseException("Data is not correct");
        } else {
            return value;
        }

    }

    public Discount getDiscount(int id) {
        Discount value = discountStorage.getValue(id);
        if (value == null) {
            throw new DataBaseException("Data is not correct");
        } else {
            return value;
        }
    }
}