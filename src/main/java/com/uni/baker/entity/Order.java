package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name = "receiver_phone", nullable = false)
    private String receiverPhone;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "discount_price")
    private Double discountPrice;

    @Column(name = "shipping_price")
    private Double shippingPrice;

    @Column(name = "final_price")
    private Double finalPrice;

}

