package input;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PurchaseInputBuilderTest {

    PurchaseInputBuilder purchaseInputBuilder;

    @Before
    public void setUp() {
        purchaseInputBuilder = new PurchaseInputBuilder();
    }

    @Test
    public void addProductAndDiscountTest() {
        purchaseInputBuilder = new PurchaseInputBuilder();
        purchaseInputBuilder.addProduct(1, 2);
        purchaseInputBuilder.addDiscount(1);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        PurchaseInput purchaseInput = new PurchaseInput(expected, 1);
        Assertions.assertEquals(purchaseInput, purchaseInputBuilder.build());
    }

    @Test
    public void addProductAndDiscountWhenDiscountAddedInWrongOrder() {
        purchaseInputBuilder = new PurchaseInputBuilder();
        purchaseInputBuilder.addDiscount(1);
        purchaseInputBuilder.addProduct(1, 2);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        PurchaseInput purchaseInput = new PurchaseInput(expected, 1);
        Assertions.assertEquals(purchaseInput, purchaseInputBuilder.build());
    }

    @Test
    public void addOnlyProduct() {
        purchaseInputBuilder = new PurchaseInputBuilder();
        purchaseInputBuilder.addProduct(1, 2);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 2);
        PurchaseInput purchaseInput = new PurchaseInput(expected);
        Assertions.assertEquals(purchaseInput, purchaseInputBuilder.build());
    }

    @Test
    public void addEmptyTest() {
        purchaseInputBuilder = new PurchaseInputBuilder();
        purchaseInputBuilder.addProduct(0, 0);
        purchaseInputBuilder.addDiscount(0);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        PurchaseInput purchaseInput = new PurchaseInput(expected, 0);
        Assertions.assertEquals(purchaseInput, purchaseInputBuilder.build());
    }
}
