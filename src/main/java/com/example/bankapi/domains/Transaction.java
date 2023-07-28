package com.example.bankapi.domains;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Transaction {
    @Id
    @Column(name = "id", nullable = false)
    //Unique identifier of this transaction
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sourceAccount", nullable = false)
    //Id of the account sending the funds
    private Account sourceAccount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "targetAccount", nullable = false)
    //Id of the account receiving the funds
    private Account targetAccount;

    // For example, 10.50, the amount being transferred.
    private BigDecimal amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "currency", nullable = false)
    //For example, "EUR", the currency being transferred
    private Currency currency;
}
