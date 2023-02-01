package de.dhbw.shipping.domain.db;

import jakarta.persistence.*;

@Entity
@Table(name="orders")
public class OrderEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "order_id")
    String orderId;

    @Column(name = "order_status")
    String status;
}
