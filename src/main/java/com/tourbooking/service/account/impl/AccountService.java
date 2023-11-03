package com.tourbooking.service.account.impl;

import com.tourbooking.model.account.Account;
import com.tourbooking.repository.account.IAccountRepository;
import com.tourbooking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public List<Account> findAll() {
        return iAccountRepository.findAll();
    }

    @Override
    public Account findById(int id) {
        return iAccountRepository.findById(id).get();
    }

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public void delete(int id) {
        iAccountRepository.delete(findById(id));
    }
}
