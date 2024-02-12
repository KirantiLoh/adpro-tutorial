package id.ac.ui.cs.advprog.eshop.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Iterator;

import id.ac.ui.cs.advprog.eshop.model.Product;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createAndFindProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productRepository.create(product);
        Product foundProduct = productRepository.findById("P369");
        assertEquals("P369", foundProduct.getProductId());
    }

    @Test
    void checkIfEmpty() {
        Iterator<Product> products = productRepository.findAll();
        assertFalse(products.hasNext());
    }

    @Test
    void findAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("P369");
        product1.setProductName("Laptop");
        product1.setProductQuantity(1);
        productRepository.create(product1);
        Product product2 = new Product();
        product2.setProductId("P370");
        product2.setProductName("Mouse");
        product2.setProductQuantity(1);
        productRepository.create(product2);
        Iterator<Product> products = productRepository.findAll();
        assertEquals("P369", products.next().getProductId());
        assertEquals("P370", products.next().getProductId());
        assertFalse(products.hasNext());
    }

    @Test
    void updateProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productRepository.create(product);
        Product updatedProduct = new Product();
        updatedProduct.setProductId("P369");
        updatedProduct.setProductName("Laptop");
        updatedProduct.setProductQuantity(2);
        productRepository.update("P369", updatedProduct);
        Product foundProduct = productRepository.findById("P369");
        assertEquals(2, foundProduct.getProductQuantity());
    }

    @Test
    void deleteProduct() {
        Product product = new Product();
        product.setProductId("P369");
        product.setProductName("Laptop");
        product.setProductQuantity(1);
        productRepository.create(product);
        productRepository.delete("P369");
        Product products = productRepository.findById("P369");
        assertFalse(products != null);
    }
}
