package de.dhbw.shipping.domain.api;

import java.util.List;

public record OrderDto(CustomerDto customerDto, List<OrderItemDto> items) {
}
