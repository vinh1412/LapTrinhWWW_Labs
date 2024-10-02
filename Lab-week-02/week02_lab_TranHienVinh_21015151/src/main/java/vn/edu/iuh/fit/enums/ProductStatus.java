package vn.edu.iuh.fit.enums;

public enum ProductStatus {
    ACTIVE(1), IN_ACTIVE(0), TERMINATED(-1);

    private int value;

    ProductStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value == 1 ? "ACTIVE" : value == 0 ? "IN_ACTIVE" : "TERMINATED";
    }
}
