package com.example.pos.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@Table(name = "orders")
@NoArgsConstructor
@Getter
@Setter
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    private String shipping_address;
    private Date shipping_date;
    private String shipping_status;
    private Date create_at = new Date();

    public Orders(String shipping_address, Date shipping_date, String shipping_status, Date create_at) {
        this.shipping_address = shipping_address;
        this.shipping_date = shipping_date;
        this.shipping_status = shipping_status;
        this.create_at = create_at;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;
}
