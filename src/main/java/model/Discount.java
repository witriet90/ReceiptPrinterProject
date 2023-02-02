package model;

public class Discount {
    private final int id;
    private final int value;
    private final String owner;

    public Discount(int id, int value, String owner) {
        this.id = id;
        this.value = value;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public int getValue() {
        return value;
    }

    public String getOwner() {
        return owner;
    }
}
