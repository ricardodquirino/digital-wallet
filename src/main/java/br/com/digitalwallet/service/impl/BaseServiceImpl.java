package br.com.digitalwallet.service.impl;

import br.com.digitalwallet.dto.AccountDto;
import br.com.digitalwallet.model.Account;
import br.com.digitalwallet.model.BaseModel;
import br.com.digitalwallet.service.BaseService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class BaseServiceImpl <T extends BaseModel> implements BaseService<Optional<T>> {


    protected abstract CrudRepository<T, Long> getRepository();
}
