package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "provider", length = 128)
    private String provider;


    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();
}
