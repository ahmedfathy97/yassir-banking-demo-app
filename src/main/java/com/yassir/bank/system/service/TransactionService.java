package com.yassir.bank.system.service;

import com.yassir.bank.system.model.TransactionDTO;
import com.yassir.bank.system.model.TransactionsVTO;

import java.util.List;

public interface TransactionService {


    /**
     *   transfer money from bank sourceAccount to another sourceAccount
     * @param transactionDTO
     */
    void transferTransaction(TransactionDTO transactionDTO);

    /**
     * getTransactions: get transactions history for sourceAccount.
     * @param accountId -mandatory
     *
     * @return List of Transaction
     */
    List<TransactionsVTO> getTransactions(Long accountId);
}
