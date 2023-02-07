package printer;

import receipt.Receipt;

import java.io.IOException;
import java.io.PrintWriter;

public class ReceiptFilePrinter implements Printer {
    private final ReceiptFormatter receiptFormatter = new ReceiptFormatter();

    private static final String FILE_NAME = "Receipt.txt";

    @Override
    public void print(Receipt receipt) {
        printToFile(receiptFormatter.format(receipt));
    }

    private void printToFile(String content) {
        try (PrintWriter out = new PrintWriter(FILE_NAME)) {
            out.println(content);
        } catch (IOException e) {
            System.out.println("Cannot print to file");
        }
    }
}