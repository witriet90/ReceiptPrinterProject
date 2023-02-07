package printer;

import receipt.Receipt;

/**
 * Реализация принтера, которая печатает чек в коноль.
 */
public class ReceiptConsolePrinter implements Printer {
    private final ReceiptFormatter receiptFormatter = new ReceiptFormatter();

    @Override
    public void print(Receipt receipt) {
        System.out.println(receiptFormatter.format(receipt));
    }
}
