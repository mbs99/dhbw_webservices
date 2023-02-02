package de.dhbw.shipping.domain;

import de.dhbw.shipping.domain.api.OrderDto;
import de.dhbw.shipping.domain.api.StatusDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShippingController {

    @PostMapping(path = "/api/shipping", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StatusDto startShipping(@RequestBody OrderDto orderDto) {
        return new StatusDto("99", "PENDING");
    }
    @GetMapping(path = "/api/shipping/{id}/status", produces = MediaType.APPLICATION_JSON_VALUE)
    public StatusDto shippingStatus(@PathVariable("id") String shippingId) {
        return new StatusDto(shippingId, "PENDING");
    }

    @GetMapping(path = "/api/shpping/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderDto getOrder(@PathVariable("id") String shippingId) {
        return null;
    }
}
