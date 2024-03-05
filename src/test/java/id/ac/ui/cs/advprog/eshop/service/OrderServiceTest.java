package id.ac.ui.cs.advprog.eshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.OrderRepository;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    List<Order> orders;

    @BeforeEach
    void setup() {
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        this.orders = new ArrayList<>();
        Order order1 = new Order("1234567890", products, 1708560001, "John Doe");
        Order order2 = new Order("1234567891", products, 1708560001, "John Doe");
        this.orders.add(order1);
        this.orders.add(order2);
    }

    @Test
    void testCreateOrder() {
        Order order = this.orders.get(0);
        doReturn(order).when(orderRepository).save(order);

        Order result = orderService.createOrder(order);
        verify(orderRepository, times(1)).save(order);
        assertEquals(order.getId(), result.getId());
    }

    @Test
    void testCreateOrderIfAlreadyExist() {
        Order order = this.orders.get(0);
        doReturn(order).when(orderRepository).findById(order.getId());

        assertNull(orderService.createOrder(order));
        verify(orderRepository, times(0)).save(order);
    }

    @Test
    void testUpdateStatus() {
        Order order = this.orders.get(1);
        Order newOrder = new Order(order.getId(), order.getProducts(), order.getOrderTime(), order.getAuthor(),
                "SUCCESS");
        doReturn(order).when(orderRepository).findById(order.getId());
        doReturn(newOrder).when(orderRepository).save(any(Order.class));

        Order result = orderService.updateStatus(order.getId(), OrderStatus.SUCCESS.name());
        verify(orderRepository, times(1)).findById(order.getId());
        assertEquals(order.getId(), result.getId());
        assertEquals(OrderStatus.SUCCESS.name(), result.getStatus());
    }

    @Test
    void testUpdateStatusInvalidStatus() {
        Order order = this.orders.get(1);
        doReturn(order).when(orderRepository).findById(order.getId());

        assertThrows(IllegalArgumentException.class, orderService.updateStatus(order.getId(), "INVALID_STATUS"));
        verify(orderRepository, times(0)).save(any(Order.class));
    }

    @Test
    void testFindByIdNotFound() {
        doReturn(null).when(orderRepository).findById("zzc");
        assertNull(orderService.findById("zzc"));
    }

    @Test
    void testFindByIdFound() {
        Order order = this.orders.get(1);
        doReturn(order).when(orderRepository).findById(order.getId());
        assertEquals(order.getId(), orderService.findById(order.getId()).getId());
    }

    @Test
    void testFindAllByAuthor() {
        Order order = this.orders.get(1);
        doReturn(this.orders).when(orderRepository).findAllByAuthor(order.getAuthor());
        List<Order> results = orderService.findAllByAuthor(order.getAuthor());
        for (Order result : results) {
            assertEquals(order.getAuthor(), result.getAuthor());
        }
        assertEquals(2, results.size());
    }

    @Test
    void testFindAllByAuthorIfAllLowercase() {
        Order order = this.orders.get(1);
        doReturn(new ArrayList<Order>()).when(orderRepository).findAllByAuthor(order.getAuthor().toLowerCase());
        List<Order> results = orderService.findAllByAuthor(order.getAuthor());
        assertEquals(0, results.size());
    }

}
