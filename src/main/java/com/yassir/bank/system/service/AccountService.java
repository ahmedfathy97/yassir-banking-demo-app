package com.yassir.bank.system.service;


import com.yassir.bank.system.model.AccountDTO;
import com.yassir.bank.system.model.AccountVTO;

public interface AccountService {

    /**
     * sourceAccount : create bank sourceAccount
     * create a new bank sourceAccount for the customer id
     *
     * @param accountDTO
     * @return sourceAccount-id of created sourceAccount
     */
    void createAccount(AccountDTO accountDTO);

    /**
     * getSourceAccount : get sourceAccount by id
     * @param accountId
     * @return the request Account
     *  or throw NotFoundException
     */
    AccountVTO getAccount(Long accountId);

}
