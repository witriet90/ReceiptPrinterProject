package model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return id == discount.id && value == discount.value && Objects.equals(owner, discount.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, owner);
    }
}
