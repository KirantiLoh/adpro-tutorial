package id.ac.ui.cs.advprog.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        if (orderRepository.findById(order.getId()) != null) {
            return null;
        }
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order findById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateStatus(String id, String status) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new NoSuchElementException();
        }
        Order newOrder = new Order(order.getId(), order.getProducts(), order.getOrderTime(), order.getAuthor(), status);
        orderRepository.save(newOrder);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findAllByAuthor(String author) {
        return orderRepository.findAllByAuthor(author);
    }
}
