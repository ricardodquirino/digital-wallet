package br.com.digitalwallet;

import br.com.digitalwallet.dto.TransactionRequestDto;
import br.com.digitalwallet.model.Account;
import br.com.digitalwallet.model.Transaction;
import br.com.digitalwallet.repository.AccountRepository;
import br.com.digitalwallet.repository.TransactionRepository;
import br.com.digitalwallet.service.impl.AccountServiceImpl;
import br.com.digitalwallet.service.impl.TransactionServiceImpl;
import br.com.digitalwallet.util.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    TransactionServiceImpl transactionService;
    @MockBean
    private TransactionRepository transactionRepository;

    @MockBean
    AccountServiceImpl accountService;
    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void testIfTransactionWasCreatedSuccessfully() {
        when(accountRepository.findOneByCode("10")).thenReturn(createAccontMQT());
        when(accountService.findAccountByCode("10")).thenReturn(createAccontMQT());
        when(transactionService.findAccountByTransaction(createTransactionRequestDTO())).thenReturn(createAccontMQT());
        when(transactionRepository.findById(1L)).thenReturn(createTransactionDTO());

        transactionService.create(createTransactionRequestDTO());
        assertNotNull(transactionService.findByid(1L));
    }

    @Test(expected = ResponseStatusException.class)
    public void testsTransactionWasCreatedWithAnInvalidAccount() {
        when(accountRepository.findOneByCode("10")).thenReturn(null);
        when(accountService.findAccountByCode("10")).thenReturn(null);
        when(transactionRepository.findById(1L)).thenReturn(createTransactionDTO());
        transactionService.create(createTransactionRequestDTO());
    }

    public Account createAccontMQT(){
        Account account = new Account();
        account.setCreateDate(DateUtil.getDateTimeNow());
        account.setType("CORRENTE");
        account.setActive(true);
        account.setCode("10");
        return account;
    }

    public TransactionRequestDto createTransactionRequestDTO(){
       Transaction transaction =  new Transaction();
       transaction.setId(1L);
       transaction.setAccount(createAccontMQT());
       transaction.setValue(100.0);
       transaction.setCreateDate(DateUtil.getDateTimeNow());
        return new TransactionRequestDto();
    }

    public Optional<Transaction> createTransactionDTO(){
        Transaction transaction =  new Transaction();
        transaction.setId(1L);
        transaction.setAccount(createAccontMQT());
        transaction.setValue(100.0);
        transaction.setCreateDate(DateUtil.getDateTimeNow());
        return Optional.of(transaction);
    }
}
