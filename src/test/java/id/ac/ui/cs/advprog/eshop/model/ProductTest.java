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

    @Test
    void testSetProductId() {
        this.product.setProductId("P370");
        assertEquals("P370", this.product.getProductId());
    }

    @Test
    void testSetProductName() {
        this.product.setProductName("Mouse");
        assertEquals("Mouse", this.product.getProductName());
    }

    @Test
    void testSetProductQuantity() {
        this.product.setProductQuantity(2);
        assertEquals(2, this.product.getProductQuantity());
    }

    @Test
    void testContructor() {
        Product product = new Product("P370", "Mouse", 1);
        assertEquals("P370", product.getProductId());
        assertEquals("Mouse", product.getProductName());
        assertEquals(1, product.getProductQuantity());
    }

}
