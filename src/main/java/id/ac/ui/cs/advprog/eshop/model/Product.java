package id.ac.ui.cs.advprog.eshop.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String productId;
    private String productName;
    private int productQuantity;

    public Product() {
        this.productId = "P" + (int) (Math.random() * 1000);
    }

    public String getProductId() {
        return productId;
    }

}
