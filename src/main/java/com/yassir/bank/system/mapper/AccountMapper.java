package com.yassir.bank.system.mapper;



import com.yassir.bank.system.model.AccountDTO;
import com.yassir.bank.system.model.AccountVTO;
import com.yassir.bank.system.model.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountMapper {

    @Mapping(target = "customer.id", source = "customerId")
    Account fromAccountDTOtoAccountEntity(AccountDTO accountDTO);

    @Mapping(source = "customer.id", target = "customerId")
    AccountVTO fromAccountEntityToAccountVTO(Account account);
}
