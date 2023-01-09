package de.mbs.orderservice;

import de.mbs.orderservice.dto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<OrderDto>> findById(@PathVariable("id") String id) {
        return orderService.findByOrderId(id)
                .map(order -> ResponseEntity.ok(new OrderDto(order.getOrderId())))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<OrderDto> saveOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderId(order.getOrderId());
        return orderService.upsertOrder(order).map(result -> new OrderDto(result.getOrderId()));
    }
}
