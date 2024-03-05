package id.ac.ui.cs.advprog.eshop.enums;

public enum OrderStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    FAILED("FAILED"),
    SUCCESS("SUCCESS"),
    CANCELLED("CANCELLED");

    private String value;

    OrderStatus(String value) {
        this.value = value;
    }

    public static boolean contains(String value) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
