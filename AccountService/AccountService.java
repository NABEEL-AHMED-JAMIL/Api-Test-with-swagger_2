package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mmahmood on 4/23/2017.
 */
@Service
public class AccountService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;


    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Account a = accountRepository.findByUserName(s);
        if(a != null){
            List<GrantedAuthority> auth = AuthorityUtils
                    .commaSeparatedStringToAuthorityList(a.getRole());
            String password = a.getPassword();

            return new org.springframework.security.core.userdetails.User(s, password,
                    auth);
        }
        else{
            throw  new UsernameNotFoundException("No record found");
        }
    }
}
