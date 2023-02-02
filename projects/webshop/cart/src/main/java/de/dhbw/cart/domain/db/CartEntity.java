package de.dhbw.cart.domain.db;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="carts")
public class CartEntity {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItemEntity> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemEntity> getItems() {
        return items;
    }

    public void setItems(List<CartItemEntity> items) {
        this.items = items;
    }
}
