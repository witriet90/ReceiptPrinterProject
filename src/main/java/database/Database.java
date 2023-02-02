package database;

import model.Discount;
import model.Product;

import java.util.Map;

public class Database {
    private final Storage<Product> productStorage;
    private final Storage<Discount> discountStorage;

    public Database(Map<Integer, Product> initialProducts, Map<Integer, Discount> initialDiscounts){
        productStorage = new Storage<>(initialProducts);
        discountStorage = new Storage<>(initialDiscounts);
    }

    public Database(){
        productStorage = new Storage<>();
        discountStorage = new Storage<>();
    }

    public Product getProduct(int id) {
        return productStorage.getValue(id);
    }

    public Discount getDiscount(int id) {
        return discountStorage.getValue(id);
    }
}
