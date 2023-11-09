package com.tourbooking.controller.account;

import com.tourbooking.dto.account.AccountDto;
import com.tourbooking.dto.account.PasswordDto;
import com.tourbooking.model.account.Account;
import com.tourbooking.model.tour.Tour;
import com.tourbooking.service.account.IAccountService;
import com.tourbooking.service.tour.ITourService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private ITourService tourService;
    @Autowired
    private IAccountService accountService;
    @GetMapping("/login")
    public String showLoginPage(){
        return "login-form";
    }

//    @PostMapping("/login")
//    public String login(@RequestParam(value = "username") String username,
//                        @RequestParam(value = "password") String password,
//                        Principal principal, Model model) {
//        if(!username.equals(principal.getName())) {
//            model.addAttribute("message", "Email đăng nhập không đúng.");
//        }
//        if(!password.equals(principal.))
//
//    }
    @GetMapping("/navigation")
    public String showAccountNavigation(){

        return "account-navigation";
//        return "header-footer";
    }
//    @RequestMapping(method = RequestMethod.GET)
//    public String showSongList(@PageableDefault(value = 5, sort = "employeeName",
//            direction = Sort.Direction.ASC) Pageable pageable, Model model) {
//        model.addAttribute("accounts", accountService.findAll(pageable));
//        return "account-list";
//    }
@GetMapping("/{id}/isEnable")
public  String isEnableAccount(@PathVariable Integer id,@PageableDefault(value = 5, sort = "employee_name",
        direction = Sort.Direction.ASC) Pageable pageable, Model model, RedirectAttributes redirectAttributes) {
    List<Account> accounts = accountService.findAccountFromCurrentDate();
    int count=0;
    Account account = accountService.findById(id);
    model.addAttribute("accounts", accountService.findEnableAccount(pageable));
    for (Account acc: accounts) {
        if(account.getAccountId() == acc.getAccountId()) {
            count++;
        }
    }
    if(count!=0){
        model.addAttribute("messageInfo",1);
    } else {
        accountService.isEnableAccount(id);
        redirectAttributes.addFlashAttribute("message", "Đã khoá tài khoản của nhân viên " +
                account.getEmployeeName() + " thành công.");
        model.addAttribute("messageInfo",0);
    }
    return  "account-list";
}
    @RequestMapping(method = RequestMethod.GET)
    public String showSongList(@PageableDefault(value = 5, sort = "employee_name",
            direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        model.addAttribute("messageInfo",0);
        model.addAttribute("accounts", accountService.findEnableAccount(pageable));
        return "account-list";
    }
    @GetMapping("/read")
    public ModelAndView showAccountList(){
        List<Account> accounts = accountService.findAll();
        return new ModelAndView("account-list", "accounts", accounts);
    }
//    @GetMapping("/search")
//    public ModelAndView searchByName(@RequestParam(value = "name") String name) {
//        List<Account> accounts = accountService.searchAccountByEmployeeNameContains(name);
//        return new ModelAndView("account-search", "accounts", accounts);
//    }
        @GetMapping("/search")
    public ModelAndView searchByName(@PageableDefault(value = 5, sort = "employee_name",
                direction = Sort.Direction.ASC) Pageable pageable,
                                     @RequestParam(value = "name") String name) {
        String name2=name;
        Page<Account> accounts = accountService.searchAccountByName(name, pageable);
        return new ModelAndView("account-list", "accounts", accounts);
    }

    @GetMapping("/view")
    @ResponseBody
    public ModelAndView showAccountDetailByEmail(Principal principal) {
        return new ModelAndView("account-view", "account",accountService.findByAccountEmail(principal.getName()));
    }
    @GetMapping("/create")
    public ModelAndView showAccountCreateForm(){
        return new ModelAndView("account-create", "account", new AccountDto());
    }
    @PostMapping("/create")
    public ModelAndView createAccount(@Validated @ModelAttribute(name = "account") AccountDto accountDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        if(accountService.findByAccountEmail(accountDto.getAccountEmail()) != null) {
            bindingResult.rejectValue("accountEmail", null,"Account email đã tồn tại.");
        }
        new AccountDto().validate(accountDto, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("account-create", "account", accountDto);
        } else{
            Account account = new Account();
            BeanUtils.copyProperties(accountDto, account);
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            account.setAccountPassword(bCryptPasswordEncoder.encode(account.getAccountPassword()));
            accountService.save(account);
            redirectAttributes.addFlashAttribute("message", "Đã tạo tài khoản cho nhân viên "
                    + account.getEmployeeName() + "." );
            return new ModelAndView("redirect:/account");
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
            return "redirect:/account";
        }
    }
//    @GetMapping("/{id}/delete")
//    public  String deleteAccount(@PathVariable Integer id, RedirectAttributes redirectAttributes){
//        accountService.delete(id);
//        redirectAttributes.addFlashAttribute("message","Đã xoá thông tin nhân viên thành công");
//        return  "redirect:/account";
//    }

    @GetMapping("/{id}/password")
    public ModelAndView showPasswordUpdateForm(@PathVariable Integer id) {
//        AccountDto accountDto = new AccountDto();
//        Account account = accountService.findById(id);
//        BeanUtils.copyProperties(account, accountDto);
//        return new ModelAndView("password-update", "accountDto", accountDto);
        PasswordDto passwordDto = new PasswordDto();
        return new ModelAndView("password-update", "passwordDto", passwordDto);
    }
    @PostMapping("/password")
    public String updatePassword(@Validated
                                @ModelAttribute PasswordDto passwordDto,
                                BindingResult bindingResult,

                                Principal principal,

                                RedirectAttributes redirectAttributes,
                                Model model){
        new PasswordDto().validate(passwordDto, bindingResult);
        Account account = accountService.findByAccountEmail(principal.getName());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        bCryptPasswordEncoder.matches()
//        String afterEncodeOldPass = bCryptPasswordEncoder.encode(passwordDto.getOldPassword());
        String afterEncodeNewPass = bCryptPasswordEncoder.encode(passwordDto.getNewPassword());

        if(bindingResult.hasFieldErrors()) {
            return "password-update";
        } else if(bCryptPasswordEncoder.matches(passwordDto.getOldPassword(),account.getAccountPassword()) == false) {
           redirectAttributes.addFlashAttribute("messageOld", "Không đúng mật khẩu!");
           return "redirect:/account/" + account.getAccountId() + "/password";
       } else {
           account.setAccountPassword(afterEncodeNewPass);
           accountService.save(account);
           redirectAttributes.addFlashAttribute("message", "Đã cập nhật mật khẩu thành công");
           return "redirect:/account/view";
       }
    }
    @GetMapping("/tour")
    public ModelAndView searchTourByEmployee(Principal principal) {
        Account account = accountService.findByAccountEmail(principal.getName());
        List<Tour> tours = tourService.searchTourByEmployee(account.getAccountId());
        return new ModelAndView("account-tour", "tours", tours);
    }

}
