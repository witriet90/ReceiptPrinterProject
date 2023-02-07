package printer;

import org.junit.jupiter.api.Test;
import receipt.Receipt;
import receipt.ReceiptRow;

import java.util.ArrayList;
import java.util.List;


public class ReceiptConsolePrinterTest {

    ReceiptConsolePrinter receiptConsolePrinter;


    @Test
    public void printTest() {
        receiptConsolePrinter = new ReceiptConsolePrinter();
        List<ReceiptRow> row = new ArrayList<>();
        row.add(new ReceiptRow(2, "Aplle", "$34.0", "$68.0"));

        Receipt receipt = new Receipt(row, "$68", "$0.0", "$68");

        receiptConsolePrinter.print(receipt);
    }
}