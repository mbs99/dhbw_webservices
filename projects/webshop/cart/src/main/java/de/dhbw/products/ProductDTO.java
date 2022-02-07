package de.dhbw.products;

import java.math.BigDecimal;

public class ProductDTO {

    private final String id;
    private final String title;
    private final BigDecimal price;

    public ProductDTO(String id, String title, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
