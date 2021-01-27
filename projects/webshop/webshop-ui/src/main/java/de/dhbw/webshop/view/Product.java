package de.dhbw.webshop.view;

import java.math.BigDecimal;

public class Product {

    private String webshopId;
    private String title;
    private String description;
    private BigDecimal price;

    public Product(String webshopId,String title,String description,BigDecimal price) {
        this.webshopId = webshopId;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getWebshopId() {
        return webshopId;
    }

    public void setWebshopId(String webshopId) {
        this.webshopId = webshopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
