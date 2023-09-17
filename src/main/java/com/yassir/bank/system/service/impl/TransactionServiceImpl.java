package com.yassir.bank.system.service.impl;

import com.yassir.bank.system.model.TransactionDTO;
import com.yassir.bank.system.model.TransactionsVTO;
import com.yassir.bank.system.model.entity.Account;
import com.yassir.bank.system.model.entity.Transaction;
import com.yassir.bank.system.model.enums.TransferDirection;
import com.yassir.bank.system.model.enums.TransactionType;
import com.yassir.bank.system.exception.handler.NotFoundException;
import com.yassir.bank.system.repository.AccountRepository;
import com.yassir.bank.system.repository.TransactionRepository;
import com.yassir.bank.system.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    @Transactional
    public void transferTransaction(TransactionDTO transactionDTO) {

        Account sourceAccount = getAccountById(transactionDTO.getSourceAccount());
        Account targetAccount = getAccountById(transactionDTO.getTargetAccount());

        // Todo : There're extra validation and exceptions should be added but got time limit. will try to add in future as well as the unit test
        BigDecimal sourceAccountBalanceAfterTransfer = sourceAccount.getBalance().subtract(transactionDTO.getAmount());
        BigDecimal targetAccountBalanceAfterTransfer = targetAccount.getBalance().add(transactionDTO.getAmount());

        updateAccountAndAddTransaction(transactionDTO.getTransactionType(), transactionDTO.getTransferDirection(), transactionDTO.getAmount(), sourceAccount, targetAccount, sourceAccountBalanceAfterTransfer, sourceAccount.getBalance());
        updateAccountAndAddTransaction(transactionDTO.getTransactionType(), transactionDTO.getTransferDirection() == TransferDirection.OUTCOME ? TransferDirection.INCOME : TransferDirection.OUTCOME, transactionDTO.getAmount(), targetAccount, sourceAccount, targetAccountBalanceAfterTransfer, targetAccount.getBalance());
    }

    private Account getAccountById(long accountId) {
        return accountRepository.findById(accountId).orElseThrow(NotFoundException::new);
    }

    private void updateAccountAndAddTransaction(TransactionType transactionType, TransferDirection transferDirection, BigDecimal amount, Account sourceAccount, Account targetAccount, BigDecimal accountBalanceAfterTransfer, BigDecimal accountBalanceBeforeTransfer) {
        sourceAccount.setBalance(accountBalanceAfterTransfer);
        Transaction transaction = createTransaction(transactionType, transferDirection, sourceAccount, targetAccount, amount, accountBalanceBeforeTransfer, accountBalanceAfterTransfer);
        sourceAccount.getTransactions().add(transaction);
        accountRepository.save(sourceAccount);
    }

    private Transaction createTransaction(TransactionType transactionType, TransferDirection transferDirection, Account sourceAccount, Account targetAccount, BigDecimal amount, BigDecimal accountBalanceBeforeTransfer, BigDecimal accountBalanceAfterTransfer) {
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transaction.setAmount(amount);
        transaction.setTransactionType(transactionType);
        transaction.setBalanceAfterTransaction(accountBalanceAfterTransfer);
        transaction.setTransferDirection(transferDirection);
        transaction.setBalanceBeforeTransaction(accountBalanceBeforeTransfer);
        return transaction;
    }


    @Override
    public List<TransactionsVTO> getTransactions(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(NotFoundException::new);
        List<Transaction> transactions = transactionRepository.findBySourceAccount(account);
        if (transactions.isEmpty())
            throw new NotFoundException();
        return transactions.stream().map(TransactionsVTO::new).collect(Collectors.toList());
    }

}
