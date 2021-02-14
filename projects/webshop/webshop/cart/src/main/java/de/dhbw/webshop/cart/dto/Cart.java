package de.dhbw.webshop.cart.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.dhbw.webshop.cart.db.CartEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Cart {
  public final String id;
  public List<CartItem> items = new ArrayList();

  public Cart() {
    this(UUID.randomUUID().toString());
  }

  public Cart(String id) {
    this.id = id;
  }

  public static Cart fromEntity(CartEntity entity) {
    Cart cart = new Cart(entity.cartId.toString());
    if (entity.items != null) {
      cart.items = entity.items.stream().map(CartItem::fromEntity).collect(Collectors.toList());
    }
    return cart;
  }

  @JsonIgnore
  public BigDecimal getTotal() {
    return items.stream()
        .map(item -> item.price.multiply(BigDecimal.valueOf(item.count)))
        .reduce(BigDecimal.valueOf(0), (subtotal, price) -> subtotal.add(price));
  }
}
