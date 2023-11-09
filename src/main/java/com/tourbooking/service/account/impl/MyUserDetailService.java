package com.tourbooking.service.account.impl;
import com.tourbooking.model.account.Account;
import com.tourbooking.model.account.MyUserDetail;
import com.tourbooking.repository.account.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByAccountEmail( email);

        if(account == null) {
            throw new UsernameNotFoundException("Email :" + email + " not found.");
        }

        return new MyUserDetail(account);
    }
}
