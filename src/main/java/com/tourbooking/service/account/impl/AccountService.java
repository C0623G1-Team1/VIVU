package com.tourbooking.service.account.impl;

import com.tourbooking.model.account.Account;
import com.tourbooking.model.tour.Tour;
import com.tourbooking.repository.account.IAccountRepository;
import com.tourbooking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Account findByAccountEmail(String email) {
        return iAccountRepository.findByAccountEmail(email);
    }

    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }

    @Override
    public void delete(int id) {
        iAccountRepository.delete(findById(id));
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return iAccountRepository.findAll(pageable);
    }

    @Override
    public Page<Account> searchByName(String name, Pageable pageable) {
        return iAccountRepository.findByEmployeeNameContains(name, pageable);
    }

    @Override
    public Page<Account> searchAccountByName(String name, Pageable pageable) {
        return iAccountRepository.searchAccountByName(name, pageable);
    }

//    @Override
//    public Page<Account> searchAccountByEmployeeNameContains(String name, Pageable pageable) {
//        return iAccountRepository.searchAccountByEmployeeNameContains(name, pageable);
//    }


//    @Override
//    public List<Account> searchAccountByEmployeeNameContains(String name) {
//        return iAccountRepository.searchAccountByEmployeeNameContains(name);
//    }

//    @Override
//    public List<Tour> searchTourByEmployee() {
//        return iAccountRepository.searchTourByEmployee();
//    }

    @Override
    public void isEnableAccount(int account_id) {
        iAccountRepository.isEnableAccount(account_id);
    }

    @Override
    public Page<Account> findEnableAccount(Pageable pageable) {
        return iAccountRepository.findEnableAccount(pageable);
    }

    @Override
    public List<Account> findAccountFromCurrentDate() {
        return iAccountRepository.findAccountFromCurrentDate();
    }


}
