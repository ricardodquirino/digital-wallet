package br.com.digitalwallet.dto;

import br.com.digitalwallet.model.Account;
import br.com.digitalwallet.model.Transaction;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class AccountStatementDto {

    @Getter
    private String code;
    @Getter
    private String type;
    @Getter
    private List<TransactionDto> listaTransactionDto;

    public AccountStatementDto() {
        super();
    }

    public AccountStatementDto(Account account) {
        this.code = account.getCode();
        this.type = account.getType();
        this.listaTransactionDto = TransactionDto.listTransactionToListTransactionDto(account.getTransactions());
    }
}
