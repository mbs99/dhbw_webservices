package de.mbs.orderservice;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Mono<Order> findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    public Mono<Order> upsertOrder(Order order) {
        return orderRepository.findByOrderId(order.getOrderId())
                .flatMap(entity -> orderRepository.save(entity))
                .or(orderRepository.save(order));
    }

    public Flux<Order> findAll() {
        return orderRepository.findAll();
    }

}
