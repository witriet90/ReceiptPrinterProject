package printer;

import org.junit.jupiter.api.Test;
import receipt.Receipt;
import receipt.ReceiptRow;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptFormatterTest {

    ReceiptFormatter receiptFormatter;


    @Test
    public void formatTest() {
        receiptFormatter = new ReceiptFormatter();
        List<ReceiptRow> row = new ArrayList<>();
        row.add(new ReceiptRow(2, "Aplle", "$34.0", "$68.0"));

        Receipt receipt = new Receipt(row, "$68", "$0.0", "$68");
        receiptFormatter.format(receipt);
    }
}