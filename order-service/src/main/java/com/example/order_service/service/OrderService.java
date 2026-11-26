
package com.example.orderservice.service;

import com.example.orderservice.dto.CustomerResponse;
import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestClient restClient;

    public OrderService(
            OrderRepository orderRepository,
            RestClient restClient) {

        this.orderRepository = orderRepository;
        this.restClient = restClient;
    }

    public Order createOrder(Order order) {

        CustomerResponse customer = restClient.get()
                .uri("/api/customers/{id}", order.getCustomerId())
                .retrieve()
                .body(CustomerResponse.class);

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public OrderResponse getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        CustomerResponse customer = getCustomer(order.getCustomerId());

        return new OrderResponse(
                order.getId(),
                order.getProduct(),
                order.getPrice(),
                customer
        );
    }

    public OrderResponse getOrderByCustomerId(String customerId) {

        Order order = orderRepository.findByCustomerId(customerId)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        CustomerResponse customer = getCustomer(customerId);

        return new OrderResponse(
                order.getId(),
                order.getProduct(),
                order.getPrice(),
                customer
        );
    }

    private CustomerResponse getCustomer(String customerId) {

        return restClient.get()
                .uri("/api/customers/{id}", customerId)
                .retrieve()
                .body(CustomerResponse.class);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
