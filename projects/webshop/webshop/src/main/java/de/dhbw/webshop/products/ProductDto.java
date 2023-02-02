package de.dhbw.webshop.products;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class ProductDto {

    private final String articleId;

    private final String title;
    private final String description;

    @JsonCreator
    public ProductDto(@JsonProperty("articleId") String articleId,
                      @JsonProperty("title") String title,
                      @JsonProperty("description") String description) {
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
