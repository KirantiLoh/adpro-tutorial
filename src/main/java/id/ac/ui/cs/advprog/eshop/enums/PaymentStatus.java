package id.ac.ui.cs.advprog.eshop.enums;

public enum PaymentStatus {
    WAITING_PAYMENT("WAITING_PAYMENT"),
    SUCCESS("SUCCESS"),
    REJECTED("REJECTED");

    private String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public static boolean contains(String value) {
        for (PaymentStatus status : PaymentStatus.values()) {
            if (status.name().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public String getValue() {
        return value;
    }
}
