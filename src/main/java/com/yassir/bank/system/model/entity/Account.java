package com.yassir.bank.system.model.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sourceAccount")
public class Account {

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

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "sourceAccount",
            fetch = FetchType.LAZY)
    private List<Transaction> transactions;

}
