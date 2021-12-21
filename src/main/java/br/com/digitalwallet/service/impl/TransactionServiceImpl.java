package br.com.digitalwallet.service.impl;

import br.com.digitalwallet.dto.TransactionDto;
import br.com.digitalwallet.dto.TransactionRequestDto;
import br.com.digitalwallet.model.Account;
import br.com.digitalwallet.model.Transaction;
import br.com.digitalwallet.repository.TransactionRepository;
import br.com.digitalwallet.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;

@Service
public class TransactionServiceImpl extends BaseServiceImpl<Transaction> implements Serializable{

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountServiceImpl accountService;

    public TransactionDto findByid(Long id) throws IllegalArgumentException {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transaction not found - " + id));
        return new TransactionDto(transaction);
    }

    public void create(TransactionRequestDto transactionDto) {

        Account account =  findAccountByTransaction(transactionDto);
        if(account == null )
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account not found" );

        Transaction transaction =  transactionDto.transactionDtoToTransaction(transactionDto);
        transaction.setAccount(account);
        transaction.setCreateDate(DateUtil.getDateTimeNow());
        transactionRepository.save(transaction);
    }

    public Account findAccountByTransaction(TransactionRequestDto transactionDto){
        return  accountService.findAccountByCode(transactionDto.getAccountCode());
    }

    @Override
    protected CrudRepository<Transaction, Long> getRepository() {
        return this.transactionRepository;
    }


}
