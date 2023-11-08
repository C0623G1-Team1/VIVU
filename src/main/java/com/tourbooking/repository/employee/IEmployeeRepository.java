package com.tourbooking.repository.employee;


import com.tourbooking.model.account.Account;
import com.tourbooking.model.tour.IAccountDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select account.account_id as accountId, account.employee_name as employeeName, " +
            "account.employee_phone as phoneNumber, " +
            "account.account_email as email " +
            "from account\n" +
            "where account_id not in (\n" +
            "select c.account_id\n" +
            "from `account` c \n" +
            "join tour t on c.account_id = t.account_id\n" +
            "where t.start_date between :startDate and :endDate or t.end_date  between :startDate and :endDate ) " +
            "and account.account_id <> 1 and account.is_enabled = 1", nativeQuery = true)
     List<IAccountDTO> getListEmployee(Date startDate, Date endDate);
}
