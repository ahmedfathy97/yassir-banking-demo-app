package com.yassir.bank.system.model.entity;


import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
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

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "customer",
            cascade = {CascadeType.ALL})
    private List<Account> accounts;
}
