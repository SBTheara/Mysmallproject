package com.example.pos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;
    private String name;
    private String description;
    private int quantity;
    private String brand;
    private String model;
    private String configuration;
    private double price;
    private int feature;
    private int Create_at;

    @OneToOne(mappedBy = "products")
    private FileImageDB fileImageDB;

    public Products(String name, String description, int quantity, String brand, String model, String configuration, double price, int feature, int create_at) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.brand = brand;
        this.model = model;
        this.configuration = configuration;
        this.price = price;
        this.feature = feature;
        Create_at = create_at;
    }

//    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id",referencedColumnName = "category_id",foreignKey = @ForeignKey(name = "category_id"))
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    @JsonIgnore
//    private Category category;
}
