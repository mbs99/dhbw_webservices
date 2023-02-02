package de.dhbw.webshop.cart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CartItemDto {
    private String articleId;
    private String title;
    private int count;

    public CartItemDto() {
    }

    public CartItemDto(String articleId, String title, int count) {
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
}
