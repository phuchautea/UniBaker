package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "order_variants")
public class OrderVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reviewed")
    private boolean reviewed;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "variant_price")
    private Double variantPrice;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_variant_id")
    private ProductVariant product_variant;
}
