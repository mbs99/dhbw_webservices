package de.dhbw.shipping.domain.db;

import org.springframework.data.repository.CrudRepository;

public interface OrderEntityRepo extends CrudRepository<OrderItemEntity, Long> {
}
