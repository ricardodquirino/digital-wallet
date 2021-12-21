package br.com.digitalwallet.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Accounts")
public class Account extends BaseModel {

    @Getter
    @Setter
    @Column(name = "code")
    private String code;

    @Getter
    @Setter
    @Column(name = "type")
    private String type;

    @Getter
    @Setter
    @Column(name = "active")
    private Boolean active;

    @Getter
    @Setter
    @Column(name="createDate", nullable = false)
    Date createDate;

    @Getter
    @Setter
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public Account(String code, String type, Boolean active, Date createDate) {
        this.code = code;
        this.type = type;
        this.active = active;
        this.createDate = createDate;
    }

    public Account() {
        super();
    }
}
