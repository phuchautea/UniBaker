package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "path", nullable = false)
    private String path;
    @Column(name = "filename", nullable = false)
    private String fileName;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    @Validated
//    private Product product_id;
}
