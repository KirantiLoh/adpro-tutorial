package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import java.util.List;

public interface OrderService {
    public Order createOrder(Order order);

    public Order findById(String id);

    public Order updateStatus(String id, String status);

    public List<Order> findAllByAuthor(String author);
}
