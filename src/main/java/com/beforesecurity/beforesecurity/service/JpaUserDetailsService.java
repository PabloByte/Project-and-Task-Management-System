package com.beforesecurity.beforesecurity.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.beforesecurity.beforesecurity.model.UserAccount;
import com.beforesecurity.beforesecurity.repository.UsserAccountRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {


        private final UsserAccountRepository userAccountRepository;

        public JpaUserDetailsService(UsserAccountRepository userAccountRepository) {
                this.userAccountRepository = userAccountRepository;
        }




        @Transactional(readOnly=true)
        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        
                Optional<UserAccount> userOptional = userAccountRepository.findByUserName(username);

                if(userOptional.isEmpty()){
                      throw new UsernameNotFoundException(String.format("Username %s does not exist in the system ", username)); 
                }

                UserAccount userAccount = userOptional.orElseThrow();

                List<GrantedAuthority> authoritys = userAccount.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getRoleName()))
                        .collect(Collectors.toList());

                return new  User (userAccount.getUserName(), userAccount.getPassword(), userAccount.isEnabled(), true,true,
                true,authoritys);       
               


        }























}
