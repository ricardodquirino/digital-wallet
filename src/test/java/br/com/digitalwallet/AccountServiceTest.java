package br.com.digitalwallet;

import br.com.digitalwallet.dto.AccountRequestDto;
import br.com.digitalwallet.model.Account;
import br.com.digitalwallet.repository.AccountRepository;
import br.com.digitalwallet.service.impl.AccountServiceImpl;
import br.com.digitalwallet.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

    @Autowired
    AccountServiceImpl accountService;
    @MockBean
    private AccountRepository repository;

    @Test
    public void testGetUsAccount() {
        when(repository.findAll()).thenReturn(Stream
                .of(createAccontMQT()).collect(Collectors.toList()));
        assertEquals(1, accountService.findAll().size());
    }

    @Test
    public void testIfAccountWasCreatedSuccessfully(){
        when(repository.findOneByCode("10")).thenReturn(createAccontMQT());
        assertEquals("10", accountService.findAccountByCode("10").getCode());
    }

    @Test(expected = ResponseStatusException.class)
    public void testIfAccountWasCreatedWithExistingCodeErr(){
        when(repository.findOneByCode("10")).thenReturn(createAccontMQT());
        assertEquals("10", accountService.findAccountByCode("10").getCode());
        accountService.create(new AccountRequestDto(createAccontMQT()));
    }

    public Account createAccontMQT(){
        Account account = new Account();
        account.setCreateDate(DateUtil.getDateTimeNow());
        account.setType("CORRENTE");
        account.setActive(true);
        account.setCode("10");
        return account;
    }
}
