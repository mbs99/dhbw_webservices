package de.mbs.orderservice;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {

    Mono<Order> findByOrderId(String orderId);
}
