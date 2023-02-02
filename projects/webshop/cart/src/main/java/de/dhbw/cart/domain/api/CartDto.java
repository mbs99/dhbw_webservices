package de.dhbw.cart.domain.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties
public class CartDto {

    private final Long cartId;
    private final List<CartItemDto> items;

    @JsonCreator
    public CartDto(@JsonProperty("cartId") Long cartId,
                   @JsonProperty("items") List<CartItemDto> items) {
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
