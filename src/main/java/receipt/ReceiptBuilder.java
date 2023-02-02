package receipt;

import model.Discount;
import model.Product;

import java.util.*;

public class ReceiptBuilder {

    private static final int DEFAULT_DISCOUNT_VALUE = 0;
    private static final String DOLLAR_SIGN = "$";

    private final Map<Product, Integer> receiptProducts = new HashMap<>();

    private Discount discount = null;

    public void addProduct(Product product, int quantity) {
        receiptProducts.put(product, quantity);
    }

    public void addDiscount(Discount discount) {
        this.discount = discount;
    }

    public Receipt build() {
        ReceiptCalculator calculator = new ReceiptCalculator();

        int discountValue = discount != null ? discount.getValue() : DEFAULT_DISCOUNT_VALUE;

        return new Receipt(
                convertProductsToRows(receiptProducts.keySet(), calculator),
                addCurrency(calculator.getTotal()),
                addCurrency(calculator.getAmountOfDiscount(discountValue)),
                addCurrency(calculator.getTotalAfterDiscount())
        );
    }

    private List<ReceiptRow> convertProductsToRows(Set<Product> allProducts, ReceiptCalculator calculator){
        List<ReceiptRow> receiptRows = new ArrayList<>();

        for (Product product : allProducts) {
            int quantity = receiptProducts.get(product);
            double totalProductCost = calculator.addProduct(product.getPrice(), quantity);

            receiptRows.add(new ReceiptRow(quantity, product.getName(), addCurrency(product.getPrice()), addCurrency(totalProductCost)));
        }

        return receiptRows;
    }

    private String addCurrency(double value) {
        return DOLLAR_SIGN + value;
    }
}
