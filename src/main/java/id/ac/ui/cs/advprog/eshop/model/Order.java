package id.ac.ui.cs.advprog.eshop.model;

import java.util.Arrays;
import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Order {
    String id;
    List<Product> products;
    long orderTime;
    String author;
    String status;

    public Order(String id, List<Product> products, long orderTime, String author) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.products = products;
        this.orderTime = orderTime;
        this.author = author;
        this.status = "WAITING_PAYMENT";
    }

    public Order(String id, List<Product> products, long orderTime, String author, String status) {
        this(id, products, orderTime, author);
        this.setStatus(status);
    }

    public void setStatus(String status) {
        String[] validStatus = { "WAITING_PAYMENT", "FAILED", "SUCCESS", "CANCELLED" };

        if (Arrays.stream(validStatus).noneMatch(status::equals)) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }
}
