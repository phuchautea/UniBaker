package com.uni.baker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private long id;

    @Column(name = "provider", length = 128)
    private String provider;
}
