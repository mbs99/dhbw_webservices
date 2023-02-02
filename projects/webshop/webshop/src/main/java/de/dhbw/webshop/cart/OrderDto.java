package de.dhbw.webshop.cart;

import java.util.List;

public record OrderDto(CustomerDto customerDto, List<OrderItemDto> items) {
}
