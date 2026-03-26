package com.beforesecurity.beforesecurity.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.beforesecurity.beforesecurity.dto.UserAccountDtoInsert;
import com.beforesecurity.beforesecurity.dto.UserAccountDtoReturn;
import com.beforesecurity.beforesecurity.mapper.TodoListMapper;
import com.beforesecurity.beforesecurity.model.Role;
import com.beforesecurity.beforesecurity.model.UserAccount;
import com.beforesecurity.beforesecurity.repository.RoleRepository;
import com.beforesecurity.beforesecurity.repository.UsserAccountRepository;

import jakarta.transaction.Transactional;

@Service
public class UserAccountServiceImpl implements  IUserAccountService {

        private final UsserAccountRepository usserAccountRepository;
        private final TodoListMapper mapper;
        private final RoleRepository roleRepository;
        private final PasswordEncoder passwordEncoder;
    

        public UserAccountServiceImpl(UsserAccountRepository usserAccountRepository, TodoListMapper mapper,
                        RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
                this.usserAccountRepository = usserAccountRepository;
                this.mapper = mapper;
                this.roleRepository = roleRepository;
                this.passwordEncoder = passwordEncoder;
        }

        @Override
        public List<UserAccountDtoReturn> showAccounts() {

           List<UserAccount> list = usserAccountRepository.findAll();
                
           
           return  mapper.listUserAccountToUserAccountDtoReturns(list);
        }



@Override
 @Transactional
public UserAccountDtoReturn saveAdministrator(UserAccountDtoInsert userInf) {


        UserAccount newUserAccount = new  UserAccount();

        newUserAccount.setUserName(userInf.getUserName());
        newUserAccount.setEmail(userInf.getEmail());
         newUserAccount.setRegisteredAt(LocalDate.now());


                Set<Role> roles ;
                // caso que no se envie el rol en el frontend
     if(userInf.getRoleIds() == null || userInf.getRoleIds().isEmpty()){

                        Role defaultRole = roleRepository.findByroleName("ROLE_USER")
                                                .orElseThrow(()->   new  RuntimeException("USUARIO NO CREADO") );

                                                roles = Set.of(defaultRole);        
        }else{

                 //  CASO 2: SÍ envía roles → validarlos 
        roles = new HashSet<>(roleRepository.findAllById(userInf.getRoleIds()));

        if (roles.size() != userInf.getRoleIds().size()) {
             throw  new RuntimeException("algun ROL no existe "); 
             
        }
        
        }

         

    String passwordEncoderInsert = passwordEncoder.encode(userInf.getPassword());

    newUserAccount.setRoles(roles);
    newUserAccount.setPassword(passwordEncoderInsert);


    UserAccount user = usserAccountRepository.save(newUserAccount);

    return mapper.UserAccountToUserAccountDtoReturn(user);
       

        }     



@Override
 @Transactional
public UserAccountDtoReturn register(UserAccountDtoInsert userInf) {

        UserAccount newUserAccount = new  UserAccount();
        newUserAccount.setUserName(userInf.getUserName());
        newUserAccount.setEmail(userInf.getEmail());
         newUserAccount.setRegisteredAt(LocalDate.now());


        Set<Role> roles ;
        // caso que no se envien roles
        if(userInf.getRoleIds() == null || userInf.getRoleIds().isEmpty() ){

        Role defaultRole = roleRepository.findByroleName("ROLE_USER")
                .orElseThrow(()->   new  RuntimeException("SOLO CUENTAS DE USUARIO") );

                                                roles = Set.of(defaultRole);        
        }else{

                        //  CASO 2: SÍ envía roles → validarlos y cambiarlo a user
        roles = new HashSet<>(roleRepository.findAllById(userInf.getRoleIds()));

        if (roles.size() == 1) {

             Role defaultRole = roleRepository.findByroleName("ROLE_USER")
                                                .orElseThrow(()->   new  RuntimeException("usuario no creado") );
                                                roles = Set.of(defaultRole);   
        }
        }

         

    String passwordEncoderInsert = passwordEncoder.encode(userInf.getPassword());

    newUserAccount.setRoles(roles);
    newUserAccount.setPassword(passwordEncoderInsert);


    UserAccount user = usserAccountRepository.save(newUserAccount);

    return mapper.UserAccountToUserAccountDtoReturn(user);
       

        } 













}
