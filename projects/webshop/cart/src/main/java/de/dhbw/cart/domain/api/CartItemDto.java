package de.dhbw.cart.domain.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class CartItemDto {

    private final String title;
    private final String articleId;
    private final int count;

    @JsonCreator
    public CartItemDto(@JsonProperty("title") String title,
                       @JsonProperty("articleId") String articleId,
                       @JsonProperty("count") int count) {
        this.title = title;
        this.articleId = articleId;
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public String getArticleId() {
        return articleId;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "title='" + title + '\'' +
                ", articleId='" + articleId + '\'' +
                ", count=" + count +
                '}';
    }
}
