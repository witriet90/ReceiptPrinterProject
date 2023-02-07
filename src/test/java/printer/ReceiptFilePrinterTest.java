package printer;

import org.junit.jupiter.api.Test;
import receipt.Receipt;
import receipt.ReceiptRow;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ReceiptFilePrinterTest {

    ReceiptFilePrinter receiptFilePrinter;

    @Test
    public void printTest() {
        receiptFilePrinter = new ReceiptFilePrinter();
        List<ReceiptRow> rows = new ArrayList<>();
        rows.add(new ReceiptRow(1, "Cucamber", "12.0", "12.0"));
        Receipt receipt = new Receipt(rows, "12.0", "0.0", "12.0");
        receiptFilePrinter.print(receipt);
    }
}