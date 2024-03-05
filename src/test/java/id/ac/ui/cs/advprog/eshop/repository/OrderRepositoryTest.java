package id.ac.ui.cs.advprog.eshop.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Product;

class OrderRepositoryTest {
    OrderRepository orderRepository;

    List<Order> orders;

    @BeforeEach
    void setUp() {
        this.orderRepository = new OrderRepository();

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        orders = new ArrayList<>();
        Order order1 = new Order("1234567890", products, 1708560001, "John Doe");
        Order order2 = new Order("1234567891", products, 1708560001, "John Doe");
        Order order3 = new Order("1234567892", products, 1708560001, "Jane Doe");
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }

    @Test
    void testSaveCreateOrder() {
        Order order = this.orders.get(1);
        Order result = orderRepository.save(order);

        Order findResult = orderRepository.findById(order.getId());

        assertEquals(order.getId(), result.getId());
        assertEquals(order.getId(), findResult.getId());
        assertEquals(order.getOrderTime(), findResult.getOrderTime());
        assertEquals(order.getAuthor(), findResult.getAuthor());
        assertEquals(order.getStatus(), findResult.getStatus());
    }

    @Test
    void testSaveUpdateOrder() {
        Order order = this.orders.get(1);
        orderRepository.save(order);

        Order updatedOrder = orderRepository.save(
                new Order(order.getId(), order.getProducts(), order.getOrderTime(), order.getAuthor(), "SUCCESS"));
        Order result = orderRepository.save(updatedOrder);
        Order findResult = orderRepository.findById(order.getId());

        assertEquals(order.getId(), result.getId());
        assertEquals(order.getId(), findResult.getId());
        assertEquals(order.getOrderTime(), findResult.getOrderTime());
        assertEquals(order.getAuthor(), findResult.getAuthor());

        assertEquals(OrderStatus.SUCCESS.name(), updatedOrder.getStatus());
    }

    @Test
    void testFindById() {
        for (Order order : this.orders) {
            orderRepository.save(order);
        }
        Order order = orders.get(1);
        Order findResult = orderRepository.findById(orders.get(1).getId());
        assertEquals(order.getId(), findResult.getId());
        assertEquals(order.getOrderTime(), findResult.getOrderTime());
        assertEquals(order.getAuthor(), findResult.getAuthor());
        assertEquals(order.getStatus(), findResult.getStatus());
    }

    @Test
    void testFindNotFound() {
        for (Order order : this.orders) {
            orderRepository.save(order);
        }
        Order findResult = orderRepository.findById("1234567890");
        assertNull(findResult);
    }

    @Test
    void testFindAllByAuthor() {
        for (Order order : this.orders) {
            orderRepository.save(order);
        }
        List<Order> findResult = orderRepository.findAllByAuthor(orders.get(1).getAuthor());
        assertEquals(2, findResult.size());
    }

    @Test
    void testFindAllByAuthorIfAllLowercase() {
        orderRepository.save(orders.get(1));
        List<Order> findResult = orderRepository.findAllByAuthor(orders.get(1).getAuthor().toLowerCase());
        assertEquals(0, findResult.size());
    }
}
