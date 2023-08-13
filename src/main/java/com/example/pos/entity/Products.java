package com.example.pos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String name;
    private String description;
    private String image;
    private int category_id;
    private int quantity;
    private String brand;
    private String model;
    private String configuration;
    private double price;
    private int feature;
    private int Create_at;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "img_id")
    private FileImageDB fileImageDB;
    public Products(String name, String description, String image, int category_id, int quantity, String brand, String model, String configuration, double price, int feature, int create_at) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.category_id = category_id;
        this.quantity = quantity;
        this.brand = brand;
        this.model = model;
        this.configuration = configuration;
        this.price = price;
        this.feature = feature;
        Create_at = create_at;
    }
}
