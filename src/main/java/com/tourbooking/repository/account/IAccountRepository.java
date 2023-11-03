package com.tourbooking.repository.account;

import com.tourbooking.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountEmail(String email);
}