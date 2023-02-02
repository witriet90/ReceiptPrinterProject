package input;

import input.PurchaseInput;

import java.util.HashMap;
import java.util.Map;

public class PurchaseInputBuilder {

    private final Map<Integer, Integer> products = new HashMap<>();

    private int discountId;
    private boolean hasDiscount = false;

    public void addProduct(int id, int quantity) {
        products.put(id, quantity);
    }

    public void addDiscount(int id) {
        discountId = id;
        hasDiscount = true;
    }

    public PurchaseInput build() {
        if (hasDiscount) {
            return new PurchaseInput(products, discountId);
        } else {
            return new PurchaseInput(products);
        }
    }
}
