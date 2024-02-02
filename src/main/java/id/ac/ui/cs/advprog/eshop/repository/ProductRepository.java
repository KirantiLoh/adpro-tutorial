package id.ac.ui.cs.advprog.eshop.repository;

import java.util.ArrayList;
import java.util.List;

import id.ac.ui.cs.advprog.eshop.model.Product;

public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    public List<Product> findAll() {
        return productData;
    }
}
