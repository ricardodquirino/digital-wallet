package br.com.digitalwallet.dto;

import br.com.digitalwallet.model.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class AccountDto {

    @Getter
    private String code;
    @Getter
    private String type;
    @Getter
    @Setter
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    public AccountDto() {
        super();
    }

    public AccountDto(Account account) {
        this.code = account.getCode();
        this.type = account.getType();
        this.createDate = account.getCreateDate();
    }

    public static Account accountDtoToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setCode(accountDto.getCode());
        account.setType(accountDto.getType());
        account.setCreateDate(accountDto.getCreateDate());
        return  account;
    }
}
