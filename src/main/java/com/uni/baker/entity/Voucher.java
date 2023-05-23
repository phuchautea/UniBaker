package com.uni.baker.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "vouchers")
public class Voucher {
    @Id
    private Long id;

    @Column(name = "discount_code", length = 128)
    private String discountCode;

    @Column(name = "discount_value", length = 128)
    private String discountValue;

    @Column(name = "minimum_spent")
    private Double minimumSpent;

    @Column(name = "discount_max_value")
    private Double discountMaxValue;

    @Column(name = "valid_from", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime validFrom;

    @Column(name = "valid_to", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime validTo;

    @Column(name = "max_usage")
    private Integer maxUsage;

    @Column(name = "used_count")
    private Integer usedCount;

    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<VoucherUsage> voucherUsages;

}
