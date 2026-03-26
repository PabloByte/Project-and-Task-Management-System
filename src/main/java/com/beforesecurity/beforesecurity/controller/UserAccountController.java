package com.beforesecurity.beforesecurity.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beforesecurity.beforesecurity.dto.UserAccountDtoInsert;
import com.beforesecurity.beforesecurity.dto.UserAccountDtoReturn;
import com.beforesecurity.beforesecurity.service.UserAccountServiceImpl;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;


@RestController
@RequestMapping("/UserAccount")
public class UserAccountController {


        private final UserAccountServiceImpl userAccountServiceImpl;

        public UserAccountController(UserAccountServiceImpl userAccountServiceImpl) {
                this.userAccountServiceImpl = userAccountServiceImpl;
        }
        

        // este es el privado para administradores
        @PostMapping("createUserOrAdmin")
        ResponseEntity<?> createUserAdmin (@RequestBody @Validated UserAccountDtoInsert userInformation){

                UserAccountDtoReturn newUserAccount = userAccountServiceImpl.saveAdministrator(userInformation);
                

                return ResponseEntity.status(HttpStatus.CREATED).body(newUserAccount);
        }


// este es el publico para registrar ususarios
           @PostMapping("register")
        ResponseEntity<?> register (@RequestBody @Validated UserAccountDtoInsert userInformation){

                UserAccountDtoReturn newUserAccount = userAccountServiceImpl.register(userInformation);

                return ResponseEntity.status(HttpStatus.CREATED).body(newUserAccount);
        }


        @GetMapping("showAccounts")
        ResponseEntity<?> showAllAccounts (){

                List<UserAccountDtoReturn> list = userAccountServiceImpl.showAccounts();

                return ResponseEntity.status(HttpStatus.ACCEPTED).body(list);
        }



        

























}
