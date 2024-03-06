package id.ac.ui.cs.advprog.eshop.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class PaymentRepositoryTest {
    PaymentRepository paymentRepository;

    List<Order> orders = new ArrayList<>();

    private Map<String, String> paymentData = new HashMap<>();

    @BeforeEach
    void setUp() {
        this.paymentRepository = new PaymentRepository();
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        Order order1 = new Order("1234567890", products, 1708560001, "John Doe");
        Order order2 = new Order("1234567891", products, 1708560001, "John Doe");
        Order order3 = new Order("1234567892", products, 1708560001, "Jane Doe");
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);

        paymentData.put("voucherCode", "ESHOP1234ABC5678");

    }

    @Test
    void testAddPayment() {
        Order order = orders.get(0);
        Payment result = paymentRepository.addPayment(order, PaymentMethod.VOUCHER.name(), paymentData);

        assertEquals(order.getId(), result.getId());
    }

    @Test
    void testAddPaymentInvalidVoucher() {
        Order order = orders.get(0);
        paymentData.put("voucherCode", "INVALID_VOUCHER");
        Payment result = paymentRepository.addPayment(order, PaymentMethod.VOUCHER.name(), paymentData);

        assertEquals(PaymentStatus.REJECTED.getValue(), result.getStatus());
    }

    @Test
    void testGetPayment() {
        Order order = orders.get(0);
        Payment payment = paymentRepository.addPayment(order, PaymentMethod.VOUCHER.name(), paymentData);

        Payment result = paymentRepository.getPayment(order.getId());
        assertEquals(payment.getId(), result.getId());
    }

    @Test
    void testGetPaymentIfNotExist() {
        Payment result = paymentRepository.getPayment("1234567890");
        assertNull(result);
    }

    @Test
    void testUpdatePayment() {
        Order order = orders.get(0);
        paymentRepository.addPayment(order, PaymentMethod.VOUCHER.name(), paymentData);

        paymentRepository.updatePaymentStatus(order.getId(), "SUCCESS");
        Payment result = paymentRepository.getPayment(order.getId());
        assertEquals("SUCCESS", result.getStatus());
    }

    @Test
    void testUpdatePaymentIfNotExist() {
        paymentRepository.updatePaymentStatus("123456789023", "SUCCESS");
        Payment result = paymentRepository.getPayment("1234567890");

        assertNull(result);
    }

    @Test
    void testSetInvalidStatus() {
        Order order = orders.get(0);
        paymentRepository.addPayment(order, PaymentMethod.VOUCHER.name(), paymentData);

        assertThrows(IllegalArgumentException.class,
                () -> paymentRepository.updatePaymentStatus(order.getId(), "INVALID_STATUS"));
    }

    @Test
    void testGetAllPayments() {
        Order order1 = orders.get(0);
        Order order2 = orders.get(1);
        paymentRepository.addPayment(order1, PaymentMethod.VOUCHER.name(), paymentData);
        paymentRepository.addPayment(order2, PaymentMethod.VOUCHER.name(), paymentData);

        List<Payment> result = paymentRepository.getAllPayments();
        assertEquals(2, result.size());
    }

    @Test
    void testGetAllPaymentsIfEmpty() {
        List<Payment> result = paymentRepository.getAllPayments();
        assertEquals(0, result.size());
    }
}
