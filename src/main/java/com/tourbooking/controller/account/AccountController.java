package com.tourbooking.controller.account;

import com.tourbooking.dto.account.AccountDto;
import com.tourbooking.model.account.Account;
import com.tourbooking.service.account.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView showAccountDetail(@PathVariable Integer id){
        Account account = accountService.findById(id);
        return new ModelAndView("account-view", "account", account);
    }
    @GetMapping("/create")
    public ModelAndView showAccountCreateForm(){
        return new ModelAndView("account-create", "account", new AccountDto());
    }
    @PostMapping("/create")
    public String createAccount(@Validated @ModelAttribute(name = "account") AccountDto accountDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        new AccountDto().validate(accountDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "account-create";
        } else{
            Account account = new Account();
            BeanUtils.copyProperties(accountDto, account);
            accountService.save(account);
            redirectAttributes.addFlashAttribute("message", "Đã tạo tài khoản cho nhân viên "
                    + account.getEmployeeName() + "." );
            return "redirect:/account/read";
        }
    }
    @GetMapping("/{id}/update")
    public ModelAndView showAccountUpdateForm(@PathVariable Integer id, Model model){
        Account account = accountService.findById(id);
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        model.addAttribute("updateId", id);
        return new ModelAndView("account-update", "accountDto", accountDto);
    }
    @PostMapping("/{id}/update")
    public String updateAccount(@Validated
                                @ModelAttribute AccountDto accountDto,
                                BindingResult bindingResult,
                                @PathVariable Integer id,
                                RedirectAttributes redirectAttributes,
                                Model model){
        new AccountDto().validate(accountDto, bindingResult);
        if(bindingResult.hasFieldErrors()) {
            return "account-update";
        } else {
            Account account = accountService.findById(id);
            BeanUtils.copyProperties(accountDto, account);
            accountService.save(account);
            redirectAttributes.addFlashAttribute("message",
                    "Đã chỉnh sửa thông tin nhân viên " + account.getEmployeeName() + "." );
            return "redirect:/account/read";
        }
    }
    @GetMapping("/{id}/delete")
    public  String deleteAccount(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        accountService.delete(id);
        redirectAttributes.addFlashAttribute("message","Đã xoá thông tin nhân viên thành công");
        return  "redirect:/account/read";
    }


}
