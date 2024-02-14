package id.ac.ui.cs.advprog.eshop.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductServiceImpl productService = new ProductServiceImpl(new ProductRepository());

    @BeforeEach
    void setUp() {
    }

    @Test
    void createAndFindProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productService.create(product);
        Product foundProduct = productService.findById("P369");
        assertEquals("P369", foundProduct.getProductId());
    }

    @Test
    void checkIfEmpty() {
        List<Product> products = productService.findAll();
        assertEquals(0, products.size());
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productService.create(product);
        Product updatedProduct = new Product();
        updatedProduct.setProductId("P369");
        updatedProduct.setProductName("Laptop baru");
        updatedProduct.setProductQuantity(2);
        productService.update("P369", updatedProduct);
        Product foundProduct = productService.findById("P369");
        assertEquals(2, foundProduct.getProductQuantity());
    }

    @Test
    void updateNonExistingProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productService.create(product);
        Product updatedProduct = new Product();
        updatedProduct.setProductName("Laptop baru");
        updatedProduct.setProductQuantity(2);
        productService.update("P368", updatedProduct);
        Product foundProduct = productService.findById("P369");
        assertEquals(1, foundProduct.getProductQuantity());
    }

    @Test
    void deleteProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productService.create(product);
        productService.delete("P369");
        Product products = productService.findById("P369");
        assertFalse(products != null);
    }

    @Test
    void findAllProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productService.create(product);
        List<Product> products = productService.findAll();
        assertEquals(1, products.size());
    }

    @Test
    void deleteNonExistingProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productService.create(product);
        productService.delete("P369");
        productService.delete("P369");
        Product products = productService.findById("P369");
        assertFalse(products != null);
    }
}
