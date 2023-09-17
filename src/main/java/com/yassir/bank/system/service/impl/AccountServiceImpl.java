package com.yassir.bank.system.service.impl;


import com.yassir.bank.system.model.AccountDTO;
import com.yassir.bank.system.model.AccountVTO;
import com.yassir.bank.system.model.entity.Account;
import com.yassir.bank.system.exception.handler.NotFoundException;
import com.yassir.bank.system.mapper.AccountMapper;
import com.yassir.bank.system.repository.AccountRepository;
import com.yassir.bank.system.service.AccountService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    private static final AccountMapper accountMapper = Mappers.getMapper(AccountMapper.class);
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(AccountDTO accountDTO) {
        Account accountEntity = accountMapper.fromAccountDTOtoAccountEntity(accountDTO);
        accountRepository.save(accountEntity);
    }

    @Override
    public AccountVTO getAccount(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(NotFoundException::new);
        return accountMapper.fromAccountEntityToAccountVTO(account);
    }

}
