package com.yassir.bank.system.model.entity;


import com.yassir.bank.system.model.enums.TransferDirection;
import com.yassir.bank.system.model.enums.TransactionType;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "transferDirection", nullable = false)
    private TransferDirection transferDirection;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "balanceBeforeTransaction", nullable = false)
    private BigDecimal balanceBeforeTransaction;

    @Column(name = "balanceAfterTransaction", nullable = false)
    private BigDecimal balanceAfterTransaction;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    private Account sourceAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "target_account_id", referencedColumnName = "id", nullable = false)
    private Account targetAccount;

}
