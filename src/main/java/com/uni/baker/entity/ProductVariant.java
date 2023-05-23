package com.uni.baker.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ProductVariant")
public class ProductVariant {
    @Id
    private long id;

    @Column(name = "name", length = 128)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "discount_price")
    private double discountPrice;

    @Column(name = "stock")
    private int stock;

}