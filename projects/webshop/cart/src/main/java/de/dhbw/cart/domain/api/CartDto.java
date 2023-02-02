package de.dhbw.cart.domain.api;

import java.util.List;

public class CartDto {

    private final Long cartId;
    private final List<CartItemDto> items;

    public CartDto(Long cartId, List<CartItemDto> items) {
        this.cartId = cartId;
        this.items = items;
    }

    public Long getCartId() {
        return cartId;
    }

    public List<CartItemDto> getItems() {
        return items;
    }
}
