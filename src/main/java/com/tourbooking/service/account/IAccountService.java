package com.tourbooking.service.account;

import com.tourbooking.model.account.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(int id);
    void save(Account account);
    void delete(int id);

}
