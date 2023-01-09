package de.mbs.orderservice.dto;

public class OrderDto {

    private final String id;

    public OrderDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
