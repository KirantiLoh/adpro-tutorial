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

        return null;
    }

    public Payment getPayment(String id) {
        return null;
    }

    public List<Payment> getAllPayments() {
        return payments;
    }

    public Payment updatePaymentStatus(String id, String status) {

        return null;
    }
}
