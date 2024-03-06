package id.ac.ui.cs.advprog.eshop.repository;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.eshop.enums.PaymentMethod;
import id.ac.ui.cs.advprog.eshop.enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;

@Repository
public class PaymentRepository {
    private List<Payment> payments = new ArrayList<>();

    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        Payment payment = new Payment(order.getId(), method, paymentData);
        if (!PaymentMethod.contains(method)) {
            throw new IllegalArgumentException("Invalid payment method");
        }
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException("Payment data cannot be empty");
        }
        if (method.equals(PaymentMethod.VOUCHER.name())) {
            int length = 0;
            for (char c : paymentData.get("voucherCode").toCharArray()) {
                if (Character.isDigit(c)) {
                    length += 1;
                }
            }
            if (paymentData.get("voucherCode") != null && (!paymentData.get("voucherCode").startsWith("ESHOP")
                    || paymentData.get("voucherCode").length() != 16 || length != 8)) {
                payment.setStatus(PaymentStatus.REJECTED.getValue());
            }
        } else if (method.equals(PaymentMethod.BANK_TRANSFER.name())) {
            if (paymentData.get("bankName") == null || paymentData.get("bankName").isEmpty()) {
                payment.setStatus(PaymentStatus.REJECTED.getValue());
            }
            if (paymentData.get("referenceCode") == null || paymentData.get("referenceCode").isEmpty()) {
                payment.setStatus(PaymentStatus.REJECTED.getValue());
            }
        }
        payments.add(payment);
        return payment;
    }

    public Payment getPayment(String id) {
        for (Payment payment : payments) {
            if (payment.getId().equals(id)) {
                return payment;
            }
        }
        return null;
    }

    public List<Payment> getAllPayments() {
        return payments;
    }

    public Payment updatePaymentStatus(String id, String status) {
        for (Payment payment : payments) {
            if (payment.getId().equals(id)) {
                payment.setStatus(status);
                return payment;
            }
        }
        return null;
    }
}
