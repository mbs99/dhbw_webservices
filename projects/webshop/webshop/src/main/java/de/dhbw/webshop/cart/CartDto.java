package de.dhbw.webshop.cart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties
public class CartDto {
    private Long cartId;

    private List<CartItemDto> items;

    @JsonCreator
    public CartDto(@JsonProperty("cartId") Long cartId,
                   @JsonProperty("items") List<CartItemDto> items) {
        this.cartId = cartId;
        this.items = saveInit(items);
    }

    public Long getCartId() {
        return cartId;
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    private static List<CartItemDto> saveInit(List<CartItemDto> items) {
        return items == null ? new ArrayList<>() : items;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartId=" + cartId +
                ", items=" + items +
                '}';
    }
}
