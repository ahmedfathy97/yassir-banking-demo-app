package com.yassir.bank.system.repository;


import com.yassir.bank.system.model.entity.Account;
import com.yassir.bank.system.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySourceAccount(Account account);
}
