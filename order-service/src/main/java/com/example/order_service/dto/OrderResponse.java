
package com.example.orderservice.dto;

public record OrderResponse(
        Long orderId,
        String product,
        double price,
        CustomerResponse customer
) {
}
