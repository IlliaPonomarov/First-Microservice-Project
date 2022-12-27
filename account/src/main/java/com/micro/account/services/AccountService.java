package com.micro.account.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import com.micro.account.models.Account;
import com.micro.account.models.Customer;
import com.micro.account.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AccountService {
    
    private final AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }


    public List<Account> findAll() {
        return accountRepo.findAll();
    }

    public Optional<Account> findById(Long id) {
        return accountRepo.findById(id);
    }

    public Optional<Account> findByCustomerId(int id) {

        try {

        }catch (NullPointerException exc) {
            return  Optional.empty();
        }
        return Optional.of(accountRepo.findByCustomerId(id));
    }

    @Transactional
    public void save(Account account) {
        account.setCreateDt(new Date());
        accountRepo.save(account);
    }

    @Transactional
    public void update(Account account) {
        accountRepo.save(account);
    }

}
