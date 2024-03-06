package id.ac.ui.cs.advprog.eshop.enums;

public enum PaymentMethod {
    VOUCHER("VOUCHER"),
    BANK_TRANSFER("BANK_TRANSFER");

    private String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public static boolean contains(String value) {
        for (PaymentMethod method : PaymentMethod.values()) {
            if (method.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
