package br.com.digitalwallet.controller;

import br.com.digitalwallet.dto.AccountDto;
import br.com.digitalwallet.dto.AccountRequestDto;
import br.com.digitalwallet.dto.AccountStatementDto;
import br.com.digitalwallet.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/wallet/account")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDto getAccountByid(@PathVariable Long id){
        return accountService.findByid(id);
    }

    @GetMapping(value = "/{accountCode}/trasactions", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountStatementDto getAccountByid(@PathVariable String accountCode){
        return accountService.getStatement(accountCode);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountRequestDto accountDto){
        accountService.create(accountDto);
    }
}
