
package com.example.orderservice.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "orders",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "customer_id")
        }
)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private double price;

    @Column(name = "customer_id", nullable = false, unique = true)
    private String customerId;

    public Order() {
    }

    public Order(String product, double price, String customerId) {
        this.product = product;
        this.price = price;
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
