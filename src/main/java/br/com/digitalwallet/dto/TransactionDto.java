package br.com.digitalwallet.dto;

import br.com.digitalwallet.model.Transaction;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionDto {

    @Getter
    private Double value;
    @Setter
    @Getter
    private Date createDate;
    @Getter
    private String accountCode;

    public TransactionDto() {
        super();
    }

    public TransactionDto(Transaction transaction) {
        this.value = transaction.getValue();
        this.createDate = transaction.getCreateDate();
        this.accountCode = transaction.getAccount().getCode();
    }

    public static Transaction transactionDtoToTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        transaction.setValue(transactionDto.getValue());
        transaction.setCreateDate(transactionDto.getCreateDate());
        return  transaction;
    }

    public static List<TransactionDto> listTransactionToListTransactionDto(List<Transaction> transactions) {

        List<TransactionDto> listTransactionDtos = new ArrayList<>();
        for(Transaction transaction : transactions){
            listTransactionDtos.add(new TransactionDto(transaction));
        }
        return listTransactionDtos;
    }
}
