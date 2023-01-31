package de.dhbw.cart.domain.db;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="carts")
public class CartEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private List<CartItemEntity> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<CartItemEntity> getItems() {
        return items;
    }

    public void setItems(List<CartItemEntity> items) {
        this.items = items;
    }
}
