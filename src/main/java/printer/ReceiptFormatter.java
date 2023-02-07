package printer;

import receipt.Receipt;
import receipt.ReceiptRow;

import java.util.List;

public class ReceiptFormatter {
    private static final String LINE_SEPARATOR = "+-----+----------------------+----------+----------+\n";
    private static final String ROW_PATTERN = "| %-3d | %-20s | %-8s | %-8s |\n";
    private static final String TOTAL_PATTERN = "| %-38s  %-8s |\n";


    public String format(Receipt receipt) {
        StringBuilder builder = new StringBuilder();
        builder.append(printHeader());
        builder.append(printRows(receipt.getRows()));
        builder.append(printTotal(receipt.getTotal(), receipt.getDiscount(), receipt.getAfterDiscount()));

        return builder.toString();
    }

    private String printHeader() {
        return "";
    }

    private String printRows(List<ReceiptRow> rows) {
        StringBuilder rowsBuilder = new StringBuilder(LINE_SEPARATOR);
        rowsBuilder.append(String.format("| %s |      %s     |   %s  |   %s  |\n",
                ApplicationStringResources.QUANTITY_TABLE_NAME,
                ApplicationStringResources.DESCRIPTION_TABLE_NAME,
                ApplicationStringResources.PRICE_TABLE_NAME,
                ApplicationStringResources.TOTAL_TABLE_NAME));
        rowsBuilder.append(LINE_SEPARATOR);

        for (ReceiptRow row : rows) {
            rowsBuilder.append(printRow(row));
        }

        return rowsBuilder.toString();
    }

    private String printTotal(String total, String discount, String afterDiscount) {
        StringBuilder totalBuilder = new StringBuilder(LINE_SEPARATOR);
        totalBuilder.append(String.format(TOTAL_PATTERN, ApplicationStringResources.TOTAL_TABLE_NAME, total));
        totalBuilder.append(String.format(TOTAL_PATTERN, ApplicationStringResources.DISCOUNT_TABLE_NAME, discount));
        totalBuilder.append(String.format(TOTAL_PATTERN, ApplicationStringResources.AFTER_DISCOUNT_NAME, afterDiscount));
        totalBuilder.append(LINE_SEPARATOR);

        return totalBuilder.toString();
    }

    private String printRow(ReceiptRow row) {
        return String.format(ROW_PATTERN, row.getQuantity(), row.getDescription(), row.getPrice(), row.getTotal());
    }
}
