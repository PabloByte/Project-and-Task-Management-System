package com.beforesecurity.beforesecurity.validations;

import org.springframework.stereotype.Component;

import com.beforesecurity.beforesecurity.repository.UsserAccountRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class UniqueEmailValidations implements  ConstraintValidator<UniqueEmail, String>{


        private final UsserAccountRepository usserAccountRepository;

        public UniqueEmailValidations(UsserAccountRepository usserAccountRepository) {
                this.usserAccountRepository = usserAccountRepository;
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {

                Boolean exist;

               if( usserAccountRepository.existsByEmail(value) == true){

                exist = false;
                return  exist;
               }else{

                exist = true;
               }

               return  exist;

        }

        













}
