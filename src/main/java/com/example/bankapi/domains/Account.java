package com.example.bankapi.domains;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Account {
    @Id
    @Column(nullable = false)
    //Unique identifier of this account
    private Long id;

    //Decimal number, must always be positive
    private BigDecimal balance;

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency", nullable = false)
    //For example, "GBP", the currency being transferred
    private Currency currency;

    @CreationTimestamp
    //When the account was created
    private Timestamp createdAt;
}
