package br.com.digitalwallet.repository;

import br.com.digitalwallet.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findOneByCode(String code);
}
