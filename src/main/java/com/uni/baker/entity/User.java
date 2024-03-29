package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "password", length = 250, nullable = false)
    private String password;

    @Column(name = "phone", length = 10, nullable = false)
    private String phone;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name="verified")
    private boolean verified;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ShippingAddress> shippingAddresses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders = new ArrayList<>();

    public User() {
        this.birthday = new Date(); // Khởi tạo birthday với thời gian hiện tại
    }
}
