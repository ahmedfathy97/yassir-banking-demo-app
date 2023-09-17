package com.yassir.bank.system.controller;


import com.yassir.bank.system.model.TransactionDTO;
import com.yassir.bank.system.model.TransactionsVTO;
import com.yassir.bank.system.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {


    TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    /**
     * POST / : transaction
     * transfer amount  from sourceAccount to another sourceAccount
     *
     * @param transactionDTO (required)
     * @return success with status 200
     * or Bad Request with status 400
     */
    @PostMapping
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionDTO transactionDTO) {
        transactionService.transferTransaction(transactionDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * GET / : transactions for sourceAccount by id .
     *
     * @param accountId to get - mandatory
     * @return List of TransactionsVTO successful operation ordered by createdAt (status code 200)
     * or Not Found (status code 404)
     */

    @GetMapping
    public ResponseEntity<List<TransactionsVTO>> getTransactionsByAccountId(@Valid @RequestParam("sourceAccountId") Long accountId) {
        return new ResponseEntity<>(transactionService.getTransactions(accountId), HttpStatus.OK);
    }

}
