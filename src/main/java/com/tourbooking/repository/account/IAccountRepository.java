package com.tourbooking.repository.account;

import com.tourbooking.model.account.Account;
import com.tourbooking.model.tour.Tour;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountEmail(String email);
//    List<Account> searchAccountByEmployeeNameContains(String name);
//    Page<Account> findAccountByEmployeeNameContaining(String name, Pageable pageable);
    Page<Account> findByEmployeeNameContains(String name, Pageable pageable);
    @Query(nativeQuery = true, value = "select * from account\n" +
            "where is_enabled = 1 and\n" +
            "employee_name=:param")
    Page<Account> searchAccountByName(@Param("param") String name, Pageable pageable);
    @Query(nativeQuery = true, value = "select * from account where is_enabled=1")
    Page<Account> findEnableAccount(Pageable pageable);

//    @Query(nativeQuery = true, value = "select * from tour as t\n" +
//            "join account as a on a.account_id = t.account_id;")
//    List<Tour> searchTourByEmployee();


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update account \n" +
            "set is_enabled = 0\n" +
            "where account_id =:param")
    void isEnableAccount(@Param("param") int account_id);

    @Query(nativeQuery = true, value = "select * from account as a \n" +
            "join tour as t on t.account_id = a.account_id\n" +
            "where t.is_deleted = 0 and (t.start_date >= current_date() or\n" +
            "t.end_date >= current_date())")
    List<Account> findAccountFromCurrentDate();


//    @Query(nativeQuery = true, value = "select * from blog where category_id=:param")
//    List<Blog> searchBlogByCategoryId(@Param("param")int keyword);

}