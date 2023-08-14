package com.example.pos.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Order;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@NoArgsConstructor
@Getter
@Setter
public class Order_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_details_id;
    private int quantity;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", insertable=false, updatable=false)
    private Orders orders;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="product_id", insertable=false, updatable=false)
    private Products products;
}
