package de.dhbw.cart.domain.api;

public class CartItemDto {

    private final String title;
    private final String articleId;
    private final int count;

    public CartItemDto(String title, String articleId, int count) {
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
}
