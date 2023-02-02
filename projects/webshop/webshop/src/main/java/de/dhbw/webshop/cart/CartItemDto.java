package de.dhbw.webshop.cart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class CartItemDto {
    private String articleId;
    private String title;
    private int count;

    public CartItemDto() {
    }

    @JsonCreator
    public CartItemDto(@JsonProperty("articleId") String articleId,
                       @JsonProperty("title") String title,
                       @JsonProperty("count") int count) {
        this.articleId = articleId;
        this.title = title;
        this.count = count;
    }

    public String getArticleId() {
        return articleId;
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CartItemDto{" +
                "articleId='" + articleId + '\'' +
                ", title='" + title + '\'' +
                ", count=" + count +
                '}';
    }
}
