package de.dhbw.webshop.cart;

import de.dhbw.webshop.cart.db.CartEntity;
import de.dhbw.webshop.cart.db.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepo extends JpaRepository<CartItemEntity, String> {
    Optional<CartItemEntity> findByCartAndItemId(CartEntity cart, String itemId);
}
