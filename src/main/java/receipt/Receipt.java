package receipt;

import java.util.List;

public class Receipt {

    private List<ReceiptRow> rows;
    private String total;
    private String discount;
    private String afterDiscount;

    public Receipt(List<ReceiptRow> rows, String total, String discount, String afterDiscount) {
        this.rows = rows;
        this.total = total;
        this.discount = discount;
        this.afterDiscount = afterDiscount;
    }

    public List<ReceiptRow> getRows() {
        return rows;
    }

    public String getTotal() {
        return total;
    }

    public String getDiscount() {
        return discount;
    }

    public String getAfterDiscount() {
        return afterDiscount;
    }
}
