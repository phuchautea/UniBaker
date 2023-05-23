package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "voucher_usages")
public class VoucherUsage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usage_date")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime usageDate;
    @Column(name = "value_used",nullable = false)
    private Integer valueUsed;
    ///voucherId
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "voucher_id", nullable = false)
    private Voucher voucher;
    //orderId



}
