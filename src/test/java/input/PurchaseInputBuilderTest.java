package input;

import model.Discount;
import model.Product;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import receipt.Receipt;
import receipt.ReceiptRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

        Map<Integer, Integer> WGRS = new HashMap<>();
        WGRS.put(1, 2);
        PurchaseInput purchaseInput = new PurchaseInput(WGRS, 1);
        Assertions.assertEquals(purchaseInput, purchaseInputBuilder.build());
    }
}