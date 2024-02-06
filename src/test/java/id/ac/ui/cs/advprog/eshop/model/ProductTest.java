package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductTest {
    Product product;

    @BeforeEach
    public void setUp() {
        this.product = new Product();
        this.product.setProductId("P369");
        this.product.setProductName("Laptop");
        this.product.setProductQuantity(1);
    }

    @Test
    void testGetProductId() {
        assertEquals("P369", this.product.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("Laptop", this.product.getProductName());
    }

    @Test
    void testGetProductQuantity() {
        assertEquals(1, this.product.getProductQuantity());
    }
}
