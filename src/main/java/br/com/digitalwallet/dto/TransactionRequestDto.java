package br.com.digitalwallet.dto;

import br.com.digitalwallet.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionRequestDto {

    @Setter
    @Getter
    private Double value;
    @Setter
    @Getter
    private String accountCode;

    public TransactionRequestDto() {
        super();
    }

    public TransactionRequestDto(Transaction transaction) {
        this.value = transaction.getValue();
        this.accountCode = transaction.getAccount().getCode();
    }

    public static Transaction transactionDtoToTransaction(TransactionRequestDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setValue(transactionDto.getValue());
        return  transaction;
    }
}
