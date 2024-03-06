package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PaymentTest {
    @Test
    void testCreateInvalidStatus() {
        Payment payment = new Payment();
        assertThrows(IllegalArgumentException.class, () -> payment.setStatus("Invalid"));
    }

    @Test
    void testCreateValidStatus() {
        Payment payment = new Payment();
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testCreatePayment() {
        Payment payment = new Payment("1234567890", "VOUCHER", "SUCCESS");
        assertEquals("1234567890", payment.getId());
        assertEquals("VOUCHER", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
    }

    @Test
    void testSetMethod() {
        Payment payment = new Payment();
        payment.setMethod("VOUCHER");
        assertEquals("VOUCHER", payment.getMethod());
    }

    @Test
    void testSetInvalidMethod() {
        Payment payment = new Payment();
        assertThrows(IllegalArgumentException.class, () -> payment.setMethod("Invalid"));
    }
}
