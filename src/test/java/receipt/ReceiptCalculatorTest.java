package receipt;


import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class ReceiptCalculatorTest {

    private ReceiptCalculator receiptCalculator;

    @Before
    public void setUp() {
        receiptCalculator = new ReceiptCalculator();
    }

    @Test
    public void addProductTest() {
        Assertions.assertEquals(75, receiptCalculator.addProduct(15, 5));

    }

    @Test
    public void addSecondProductTest() {
        receiptCalculator.addProduct(13, 5);
        Assertions.assertEquals(75, receiptCalculator.addProduct(15, 5));
    }

    @Test
    public void getTotalTest() {
        receiptCalculator.addProduct(13, 5);
        receiptCalculator.addProduct(15, 3);
        receiptCalculator.addProduct(9, 5);

        Assertions.assertEquals(155, receiptCalculator.getTotal());
    }

    @Test
    public void getAmountOfDiscountTest() {
        receiptCalculator.addProduct(13, 5);
        receiptCalculator.addProduct(15, 3);
        receiptCalculator.addProduct(9, 5);

        Assertions.assertEquals(15.5, receiptCalculator.getAmountOfDiscount(10));
    }

    @Test
    public void getTotalAfterDiscountTest() {
        receiptCalculator.addProduct(13, 5);
        receiptCalculator.addProduct(15, 3);
        receiptCalculator.addProduct(9, 5);
        receiptCalculator.getAmountOfDiscount(10);

        Assertions.assertEquals(139.5, receiptCalculator.getTotalAfterDiscount());
    }

    @Test
    public void getTotalAfterEmptyDiscount() {
        receiptCalculator.addProduct(13, 5);
        receiptCalculator.addProduct(15, 3);
        receiptCalculator.addProduct(9, 5);

        Assertions.assertEquals(155, receiptCalculator.getTotalAfterDiscount());
    }
}