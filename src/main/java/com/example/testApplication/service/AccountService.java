package com.example.testApplication.service;

import com.example.testApplication.model.Account;

import java.util.List;

public interface AccountService {

    public Account create (Account account);
    public Account update(Account account);
    public Account check(Long account );
    void deleteById(Long id );
}
