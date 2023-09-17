package com.yassir.bank.system.controller;


import com.yassir.bank.system.model.AccountDTO;
import com.yassir.bank.system.model.AccountVTO;
import com.yassir.bank.system.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/account")
public class AccountController {


    AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * POST /sourceAccount : create sourceAccount
     * create a new sourceAccount
     *
     * @param accountDTO
     * @return Successful operation with status code 201 if it saved successful
     * Bad Request if invalid request body
     */
    @PostMapping
    public ResponseEntity createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        accountService.createAccount(accountDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }


    /**
     * GET /sourceAccount/{Id} : get bank sourceAccount by id
     * get bank sourceAccount
     *
     * @param accountId required
     * @return AccountVTO with status code 200
     * or Not Found with status code 404
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<AccountVTO> getAccountById (@PathVariable("id") Long accountId) {
        return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.OK);
    }


}
