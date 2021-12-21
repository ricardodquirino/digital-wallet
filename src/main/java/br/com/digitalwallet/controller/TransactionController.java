package br.com.digitalwallet.controller;

import br.com.digitalwallet.dto.TransactionDto;
import br.com.digitalwallet.dto.TransactionRequestDto;
import br.com.digitalwallet.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/wallet/Transaction")
public class TransactionController {

    @Autowired
    private TransactionServiceImpl transactionService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TransactionDto getTransactionByid(@PathVariable Long id){
        return transactionService.findByid(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTransaction(@RequestBody TransactionRequestDto transactionDto) throws ResponseStatusException {
        transactionService.create(transactionDto);
    }
}
