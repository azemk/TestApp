package com.example.testApplication.service;

import com.example.testApplication.model.Account;
import com.example.testApplication.repository.AccountRepository;
import com.example.testApplication.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account create(Account account) {
       return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override

    public Account check(Long account ) {
        List<Account> list = accountRepository.findAll();
        for (Account acc : list
             ) {
            if(acc.getAccount().equals(account)){
                return acc;
            }
        }
        return null;
    }



    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);

    }
}
