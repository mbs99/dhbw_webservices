package de.dhbw.cart.domain.db;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CartRepo extends CrudRepository<CartEntity, Long> {

}
