package receipt;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReceiptCalculator {

    private static final int CALCULATOR_ROUNDING_SCALE = 2;

    private static final RoundingMode CALCULATOR_ROUNDING_MODE = RoundingMode.HALF_EVEN;

    private static final BigDecimal DISCOUNT_DIVIDER = new BigDecimal(100);

    private BigDecimal allProductsTotalCost = BigDecimal.ZERO;

    private BigDecimal purchaseDiscount = BigDecimal.ZERO;

    public double addProduct(double price, int quantity) {
        BigDecimal totalProductCost = round(new BigDecimal(price).multiply(new BigDecimal(quantity)));

        allProductsTotalCost = allProductsTotalCost.add(totalProductCost);

        return totalProductCost.doubleValue();
    }

    public double getTotal() {
        return allProductsTotalCost.doubleValue();
    }

    public double getAmountOfDiscount(int discount) {
        BigDecimal multiplier = new BigDecimal(discount)
                .divide(DISCOUNT_DIVIDER, CALCULATOR_ROUNDING_SCALE, CALCULATOR_ROUNDING_MODE);

        purchaseDiscount = round(allProductsTotalCost.multiply(multiplier));
        return purchaseDiscount.doubleValue();
    }

    public double getTotalAfterDiscount() {
        return allProductsTotalCost.subtract(purchaseDiscount).doubleValue();
    }

    private BigDecimal round(BigDecimal value) {
        return value.setScale(CALCULATOR_ROUNDING_SCALE, CALCULATOR_ROUNDING_MODE);
    }
}
