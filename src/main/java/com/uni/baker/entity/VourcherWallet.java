package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "voucher_wallets")
public class VourcherWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //voucherId
    //userId
}
