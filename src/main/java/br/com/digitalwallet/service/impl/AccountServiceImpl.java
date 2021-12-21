package br.com.digitalwallet.service.impl;

import br.com.digitalwallet.dto.AccountDto;
import br.com.digitalwallet.dto.AccountRequestDto;
import br.com.digitalwallet.dto.AccountStatementDto;
import br.com.digitalwallet.model.Account;
import br.com.digitalwallet.repository.AccountRepository;
import br.com.digitalwallet.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;

@Service
public class AccountServiceImpl extends BaseServiceImpl<Account> implements Serializable{

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAll() throws IllegalArgumentException {
        List<Account> source = (List<Account>) accountRepository.findAll();
        return  source;
    }

    public AccountDto findByid(Long id) throws IllegalArgumentException {
        Account account = accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Account not found - " + id));
        return new AccountDto(account);
    }

    public AccountRequestDto create(AccountRequestDto accountDto) {
        if (accountRepository.findOneByCode(accountDto.getCode()) != null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account already existing with this code: "+accountDto.getCode() );

        Account account = AccountRequestDto.accountDtoToAccount(accountDto);
        account.setCreateDate(DateUtil.getDateTimeNow());
        account.setActive(true);

        return new AccountRequestDto(accountRepository.save(account));
    }

    public Account findAccountByCode(String code) throws IllegalArgumentException {
            Account account = accountRepository.findOneByCode(code);
            if (account == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account "+code+" not found" );
            return account;
    }

    public AccountStatementDto getStatement(String accountCode) {
        Account account = accountRepository.findOneByCode(accountCode);
        if (account == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Account "+accountCode+" not found" );

        return new AccountStatementDto(account);
    }

    @Override
    protected CrudRepository<Account, Long> getRepository() {
        return this.accountRepository;
    }

}
