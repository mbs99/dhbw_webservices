package de.dhbw.cart.domain.db;

import org.springframework.data.repository.CrudRepository;

public interface CartItemRepo extends CrudRepository<CartItemEntity, Long> {
}
