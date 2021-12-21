package br.com.digitalwallet.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Transactions")
@Entity
public class Transaction extends BaseModel{

    @Getter
    @Setter
    @Column(name="value", nullable = false)
    private Double value;

    @Getter
    @Setter
    @Column(name="createDate", nullable = false)
    Date createDate;

    @Getter
    @Setter
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="account_id")
    private Account account;
}
