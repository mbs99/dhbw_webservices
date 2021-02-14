package de.dhbw.webshop.cart.dto;

import de.dhbw.webshop.cart.db.CartItemEntity;

import java.math.BigDecimal;

public class CartItem {
    public String id;
    public String title;
    public Integer count;
    public BigDecimal price;

    public static CartItem fromEntity(CartItemEntity entity) {
        CartItem item = new CartItem();
        item.id = entity.itemId;
        item.title = entity.title;
        item.count = entity.count;
        item.price = entity.price;

        return item;
    }

    public static CartItemEntity toEntity(CartItem dto) {
        CartItemEntity entity = new CartItemEntity();
        entity.itemId = dto.id;
        entity.title = dto.title;
        entity.count = dto.count;
        entity.price = dto.price;

        return entity;
    }
}
