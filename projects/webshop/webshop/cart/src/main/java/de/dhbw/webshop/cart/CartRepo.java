package de.dhbw.webshop.cart;

import de.dhbw.webshop.cart.db.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<CartEntity, String> {
}
