package com.ndyudev.lab6.service.impl;

import com.ndyudev.lab6.model.Account;
import com.ndyudev.lab6.repository.AccountRepository;
import com.ndyudev.lab6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepo;
    @Override
    public Account save(Account entity) {
        return accountRepo.save(entity);
    }

    @Override
    public void delete(String s) {
        accountRepo.deleteById(s);
    }

    @Override
    public Account findById(String s) {
        return accountRepo.findById(s).orElse(null);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }
}
