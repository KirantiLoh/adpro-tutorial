package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;

import java.util.HashMap;
import java.util.Map;

class PaymentTest {

    private Map<String, String> paymentData = new HashMap<>();

    @Test
    void testCreateInvalidStatus() {
        Payment payment = new Payment("1234567890", "VOUCHER", paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("Invalid"));
    }

    @Test
    void testCreateValidStatus() {
        Payment payment = new Payment("1234567890", "VOUCHER", paymentData);
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePayment() {
        Payment payment = new Payment("1234567890", "VOUCHER", paymentData);
        assertEquals("1234567890", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals(PaymentStatus.WAITING_PAYMENT.name(), payment.getStatus());
    }

    @Test
    void testSetMethod() {
        Payment payment = new Payment("1234567890", "VOUCHER", paymentData);
        payment.setMethod("VOUCHER");
        assertEquals("VOUCHER", payment.getMethod());
    }

    @Test
    void testSetInvalidMethod() {
        Payment payment = new Payment("1234567890", "VOUCHER", paymentData);
        assertThrows(IllegalArgumentException.class, () -> payment.setMethod("Invalid"));
    }
}
