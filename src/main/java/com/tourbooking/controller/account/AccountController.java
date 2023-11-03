package com.tourbooking.controller.account;

import com.tourbooking.model.account.Account;
import com.tourbooking.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.GeneratedValue;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @GetMapping("/read")
    public ModelAndView showAccountList(){
        List<Account> accounts = accountService.findAll();
        return new ModelAndView("account-list", "accounts", accounts);
    }
    @GetMapping("/{id}/view")
    public ModelAndView showAccountDetail(@PathVariable int id){
        Account account = accountService.findById(id);
        return new ModelAndView("account-view", "account", account);
    }
}
