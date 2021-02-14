package de.dhbw.webshop.cart.db;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="items")
public class CartItemEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="item_id")
    public String itemId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cart_id", nullable=false)
    public CartEntity cart;

    @Column(name = "count")
    public Integer count;

    @Column(name = "price")
    public BigDecimal price;

    @Column(name = "title")
    public String title;
}
