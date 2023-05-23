package com.uni.baker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Ward")
public class Ward {
    @Id
    private long id;

    @Column(name = "name", length = 128)
    private String name;
}
