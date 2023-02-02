package input;

import java.util.Map;

public class PurchaseInput {
    private final Map<Integer, Integer> products;
    private int discountId;

    private final boolean hasDiscount;

    public PurchaseInput(Map<Integer, Integer> products, int discountId) {
        this.products = products;
        this.discountId = discountId;
        this.hasDiscount = true;
    }

    public PurchaseInput(Map<Integer, Integer> products) {
        this.products = products;
        this.hasDiscount = false;
    }

    public Map<Integer, Integer> getProducts() {
        return products;
    }

    /**
     * Should be called only if hasDiscount return true
     *
     * @return discountID
     */
    public int getDiscountId() {
        return discountId;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }
}
