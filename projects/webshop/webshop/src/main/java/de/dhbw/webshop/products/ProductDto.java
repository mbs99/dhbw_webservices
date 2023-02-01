package de.dhbw.webshop.products;

public class ProductDto {

    private final String articleId;

    private final String title;
    private final String description;

    public ProductDto(String articleId, String title, String description) {
        this.articleId = articleId;
        this.title = title;
        this.description = description;
    }

    public String getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
