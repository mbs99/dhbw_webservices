package de.dhbw.cart.domain.db;

import jakarta.persistence.*;

@Entity(name = "cart_item")
public class CartItemEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "item_count")
    private int count;

    @Column(name="title")
    private String title;

    @Column(name="article_id")
    private String articleId;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private CartEntity cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public CartEntity getCart() {
        return cart;
    }

    public void setCart(CartEntity cart) {
        this.cart = cart;
    }
}
