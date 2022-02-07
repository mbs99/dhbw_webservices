package de.dhbw.products;

public class ProductDTO {

    private final String id;
    private final String description;
    private final String title;

    public ProductDTO(String id, String title, String description) {
        this.id = id;
        this.description = description;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
