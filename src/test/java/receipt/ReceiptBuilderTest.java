package receipt;

import model.Discount;
import model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ReceiptBuilderTest {
    private ReceiptBuilder receiptBuilder;

    @BeforeEach
    public void setUp() {
        receiptBuilder = new ReceiptBuilder();
    }

    @Test
    public void testAddsProductsAndDiscount() {
        Product product1 = new Product(1, "Apple", 300.67);
        Product product2 = new Product(2, "Orange", 5.89);
        Product product3 = new Product(3, "Banana", 1.25);

        Discount discount = new Discount(1, 8, "Maryia");

        receiptBuilder.addProduct(product1, 100);
        receiptBuilder.addProduct(product2, 1);
        receiptBuilder.addProduct(product3, 4);
        receiptBuilder.addDiscount(discount);

        List<ReceiptRow> rows = new ArrayList<>();
        rows.add(new ReceiptRow(100, "Apple", "$300.67", "$30067.0"));
        rows.add(new ReceiptRow(1, "Orange", "$5.89", "$5.89"));
        rows.add(new ReceiptRow(4, "Banana", "$1.25", "$5.0"));

        Receipt expectedReceipt = new Receipt(rows, "$30077.89", "$2406.23", "$27671.66");

        Assertions.assertEquals(expectedReceipt, receiptBuilder.build());
    }

    @Test
    public void testAddsProductsAndDiscountWhenDiscountAddedInWrongOrder() {
        Product product1 = new Product(1, "Apple", 300.67);
        Product product2 = new Product(2, "Orange", 5.89);
        Product product3 = new Product(3, "Banana", 1.25);

        Discount discount = new Discount(1, 8, "Maryia");

        receiptBuilder.addProduct(product1, 100);
        receiptBuilder.addProduct(product2, 1);
        receiptBuilder.addDiscount(discount);
        receiptBuilder.addProduct(product3, 4);

        List<ReceiptRow> rows = new ArrayList<>();
        rows.add(new ReceiptRow(100, "Apple", "$300.67", "$30067.0"));
        rows.add(new ReceiptRow(1, "Orange", "$5.89", "$5.89"));
        rows.add(new ReceiptRow(4, "Banana", "$1.25", "$5.0"));

        Receipt expectedReceipt = new Receipt(rows, "$30077.89", "$2406.23", "$27671.66");

        Assertions.assertEquals(expectedReceipt, receiptBuilder.build());
    }

    @Test
    public void testAddaOnlyProductsWhenDiscountNotPassed() {
        Product product1 = new Product(1, "Apple", 300.67);
        Product product2 = new Product(2, "Orange", 5.89);
        Product product3 = new Product(3, "Banana", 1.25);

        receiptBuilder.addProduct(product1, 100);
        receiptBuilder.addProduct(product2, 1);
        receiptBuilder.addProduct(product3, 4);

        List<ReceiptRow> rows = new ArrayList<>();
        rows.add(new ReceiptRow(100, "Apple", "$300.67", "$30067.0"));
        rows.add(new ReceiptRow(1, "Orange", "$5.89", "$5.89"));
        rows.add(new ReceiptRow(4, "Banana", "$1.25", "$5.0"));

        Receipt expectedReceipt = new Receipt(rows, "$30077.89", "$0.0", "$30077.89");

        Assertions.assertEquals(expectedReceipt, receiptBuilder.build());
    }

    @Test
    public void testEmptyInput() {
        Receipt expectedReceipt = new Receipt(new ArrayList<>(), "$0.0", "$0.0", "$0.0");

        Assertions.assertEquals(expectedReceipt, receiptBuilder.build());
    }
}

