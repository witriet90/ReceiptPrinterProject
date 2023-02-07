package input;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashMap;
import java.util.Map;


public class PurchaseInputTest {

    PurchaseInput purchaseInput;

    @BeforeEach
    public void setUp() {
        purchaseInput = new PurchaseInput(new HashMap<>());
    }

    @Test
    public void getProductsTest() {
        Map<Integer, Integer> extend = new HashMap<>();
        extend.put(1, 2);
        extend.put(2, 6);
        extend.put(3, 2);


        PurchaseInput input = new PurchaseInput(extend);
        Assertions.assertEquals(extend, input.getProducts());
    }

    @Test
    public void getProductsWhenThereIsNoInput() {
        Map<Integer, Integer> extend = new HashMap<>();

        PurchaseInput input = new PurchaseInput(extend);

        input.getDiscountId();

    }

    @Test
    public void getDiscountIdTest() {
        Map<Integer, Integer> purchaseInputData = new HashMap<>();

        PurchaseInput input = new PurchaseInput(purchaseInputData, 34);

        Assertions.assertEquals(34, input.getDiscountId());
    }
}