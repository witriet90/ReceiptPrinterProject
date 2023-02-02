import database.DataBaseException;
import database.Database;
import input.InputParser;
import input.PurchaseInput;
import model.Discount;
import model.Product;
import receipt.Receipt;
import printer.ReceiptConsolePrinter;
import receipt.ReceiptBuilder;

import java.util.HashMap;
import java.util.Map;

public class Program {
    private final Database database;

    public Program() {
        Map<Integer, Product> products = new HashMap<>();
        products.put(1, new Product(1, "Apple", 300.67));
        products.put(2, new Product(2, "Orange", 5.89));
        products.put(3, new Product(3, "Banana", 1.25));

        Map<Integer, Discount> discounts = new HashMap<>();
        discounts.put(1, new Discount(1, 8, "Maryia"));
        discounts.put(2, new Discount(2, 3, "Egor"));
        discounts.put(3, new Discount(3, 5, "Angela"));

        database = new Database(products, discounts);
    }

    public void run(String[] consoleInput) {
        InputParser inputParser = new InputParser();
        PurchaseInput purchaseInput = inputParser.parse(consoleInput);

        ReceiptConsolePrinter printer = new ReceiptConsolePrinter();
        printer.print(buildReceipt(purchaseInput));
    }

    private Receipt buildReceipt(PurchaseInput input) {
        ReceiptBuilder receiptBuilder = new ReceiptBuilder();
        Map<Integer, Integer> productMapping = input.getProducts();

        for (Integer productId : productMapping.keySet()) {
            addProduct(productId, productMapping.get(productId), receiptBuilder);
        }

        if (input.hasDiscount()) {
            addDiscount(input.getDiscountId(), receiptBuilder);
        }

        return receiptBuilder.build();
    }

    private void addProduct(int productId, int quantity, ReceiptBuilder builder) {
        try {
            Product product = database.getProduct(productId);
            builder.addProduct(product, quantity);
        } catch (DataBaseException e) {
            System.out.println("Product with id '" + productId + "' not found");
        }
    }

    private void addDiscount(int discountId, ReceiptBuilder builder) {
        try {
            Discount discount = database.getDiscount(discountId);
            builder.addDiscount(discount);
        } catch (DataBaseException e) {
            System.out.println("Discount with id '" + discountId + "' not found");
        }
    }
}
