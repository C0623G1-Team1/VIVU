package com.tourbooking.service.account;

import com.tourbooking.model.account.Account;
import com.tourbooking.model.tour.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    Account findById(int id);
    Account findByAccountEmail(String email);
    void save(Account account);
    void delete(int id);
    Page<Account> findAll(Pageable pageable);
//    List<Account> searchAccountByEmployeeNameContains(String name);
Page<Account> searchByName(String name, Pageable pageable);
    Page<Account> searchAccountByName(String name, Pageable pageable);
//    List<Tour> searchTourByEmployee();
    void isEnableAccount(int account_id);
    Page<Account> findEnableAccount(Pageable pageable);
    List<Account> findAccountFromCurrentDate();

}
