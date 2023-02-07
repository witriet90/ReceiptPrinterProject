package input;

import java.util.Map;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseInput input = (PurchaseInput) o;
        return discountId == input.discountId && hasDiscount == input.hasDiscount && Objects.equals(products, input.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, discountId, hasDiscount);
    }
}
