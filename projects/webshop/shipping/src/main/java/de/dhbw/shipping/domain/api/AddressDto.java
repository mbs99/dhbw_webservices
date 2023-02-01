package de.dhbw.shipping.domain.api;

public record AddressDto(String street, String nr, String zip, String city, String country) {
}
