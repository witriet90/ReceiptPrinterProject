package receipt;

public class ReceiptRow {
    private int quantity;
    private String description;
    private String price;
    private String total;

    public ReceiptRow(int quantity, String description, String price, String total) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getTotal() {
        return total;
    }
}
