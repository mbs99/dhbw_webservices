package de.dhbw.shipping.domain.api;

public record CustomerDto(String customerId, String firstName, String lastName, AddressDto shippingAddress, AddressDto paymentAddress) {
}
