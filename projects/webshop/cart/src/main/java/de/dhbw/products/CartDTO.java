package de.dhbw.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CartDTO {

    private final UUID id;
    private final List<ProductDTO> products;

    public CartDTO(UUID id, List<ProductDTO> products) {
        this.id = id;
        this.products = products;
    }

    public UUID getId() {
        return id;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public BigDecimal calcSum() {
        return Optional.ofNullable(products)
                .orElse(new ArrayList<>())
                .stream()
                .map(ProductDTO::getPrice)
                .reduce(BigDecimal.valueOf(0L), BigDecimal::add);
    }
}
