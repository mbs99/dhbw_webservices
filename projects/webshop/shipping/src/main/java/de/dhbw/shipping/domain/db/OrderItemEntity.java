package de.dhbw.shipping.domain.db;

import jakarta.persistence.*;

@Table(name = "order_items")
@Entity
public class OrderItemEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "article_nr")
    private String articleNr;

    @Column(name = "count")
    private int count;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public String getArticleNr() {
        return articleNr;
    }

    public int getCount() {
        return count;
    }

    public String getStatus() {
        return status;
    }
}
