package id.ac.ui.cs.advprog.eshop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class OrderTest {
    private List<Product> products;

    void setup() {
        this.products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("1");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        Product product2 = new Product();
        product2.setProductId("2");
        product2.setProductName("Sampo Cap Kuda");
        product2.setProductQuantity(1);
        this.products.add(product1);
        this.products.add(product2);
    }

    @Test
    void testCreateOrderEmptyProduct() {
        this.products.clear();
        assertThrows(IllegalArgumentException.class, () -> {
            Order order = new Order("1234567890", this.products, 1708560001, "John Doe");
        });
    }

    @Test
    void testCreateOrderDefaultStatus() {
        Order order = new Order("1234567890", this.products, 1708560001, "John Doe");
        assertSame(this.products, order.getProducts());
        assertEquals(2, order.getProducts().size());

        assertEquals("Sampo Cap Bambang", order.getProducts().get(0).getProductName());
        assertEquals("Sampo Cap Kuda", order.getProducts().get(1).getProductName());

        assertEquals("1234567890", order.getId());
        assertEquals(1708560001, order.getOrderTime());
        assertEquals("John Doe", order.getAuthor());
        assertEquals("WAITING_PAYMENT", order.getStatus());
    }

    @Test
    void testCreateOrderSuccess() {
        Order order = new Order("1234567890", this.products, 1708560001, "John Doe", "SUCCESS");
        assertEquals("SUCCESS", order.getStatus());
    }

    @Test
    void testCreateOrderCancelled() {
        Order order = new Order("1234567890", this.products, 1708560001, "John Doe");
        order.setStatus("CANCELLED");
        assertEquals("CANCELLED", order.getStatus());
    }

    @Test
    void testSetStatusToInvalidStatus() {
        Order order = new Order("1234567890", this.products, 1708560001, "John Doe");
        assertThrows(IllegalArgumentException.class, () -> {
            order.setStatus("INVALID_STATUS");
        });
    }
}
