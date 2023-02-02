package printer;

import receipt.Receipt;
import receipt.ReceiptRow;

import java.util.List;

/**
 * Реализация принтера, которая печатает чек в коноль.
 * TODO вынети оздание чека в String для возможноти переипользования в принтере в файл
 */
public class ReceiptConsolePrinter implements Printer {

    private static final String LINE_SEPARATOR = "+-----+----------------------+----------+----------+%n";
    private static final String ROW_PATTERN = "| %-3d | %-20s | %-8s | %-8s |%n";
    private static final String TOTAL_PATTERN = "| %-38s  %-8s |%n";

    @Override
    public void print(Receipt receipt) {
        printHeader();
        printRows(receipt.getRows());
        printTotal(receipt.getTotal(), receipt.getDiscount(), receipt.getAfterDiscount());
    }

    private void printHeader() {
    }

    private void printRows(List<ReceiptRow> rows) {
        System.out.format(LINE_SEPARATOR);

        System.out.format("| %s |      %s     |   %s  |   %s  |%n",
                ApplicationStringResources.QUANTITY_TABLE_NAME,
                ApplicationStringResources.DESCRIPTION_TABLE_NAME,
                ApplicationStringResources.PRICE_TABLE_NAME,
                ApplicationStringResources.TOTAL_TABLE_NAME
        );

        System.out.format(LINE_SEPARATOR);

        for (ReceiptRow row : rows) {
            printRow(row);
        }
    }

    private void printTotal(String total, String discount, String afterDiscount) {
        System.out.format(LINE_SEPARATOR);
        System.out.format(TOTAL_PATTERN, "Total", total);
        System.out.format(TOTAL_PATTERN, "Discount", discount);
        System.out.format(TOTAL_PATTERN, "After discount", afterDiscount);
        System.out.format(LINE_SEPARATOR);
    }

    private void printRow(ReceiptRow row) {
        System.out.format(ROW_PATTERN, row.getQuantity(), row.getDescription(), row.getPrice(), row.getTotal());
    }
}
