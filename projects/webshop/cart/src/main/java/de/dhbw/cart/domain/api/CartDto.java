package de.dhbw.cart.domain.api;

import java.util.List;

public class CartDto {

    private final String customerId;
    private final List<CartItemDto> items;

    public CartDto(String customerId, List<CartItemDto> items) {
        this.customerId = customerId;
        this.items = items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<CartItemDto> getItems() {
        return items;
    }
}
