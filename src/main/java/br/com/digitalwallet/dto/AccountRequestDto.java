package br.com.digitalwallet.dto;

import br.com.digitalwallet.model.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class AccountRequestDto {

    @Getter
    private String code;
    @Getter
    private String type;

    public AccountRequestDto() {
        super();
    }

    public AccountRequestDto(Account account) {
        this.code = account.getCode();
        this.type = account.getType();
    }

    public static Account accountDtoToAccount(AccountRequestDto accountDto) {
        Account account = new Account();
        account.setCode(accountDto.getCode());
        account.setType(accountDto.getType());
        return  account;
    }
}
