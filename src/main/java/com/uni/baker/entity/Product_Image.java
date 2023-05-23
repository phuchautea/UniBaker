package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Entity
@Table(name = "productImage")
public class Product_Image {
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
