package com.uni.baker.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "product_variants")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "discount_price")
    private double discountPrice;

    @Column(name = "stock")
    private int stock;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToMany(mappedBy = "product_variant")
    private List<OrderVariant> orderVariants = new ArrayList<>();

}
