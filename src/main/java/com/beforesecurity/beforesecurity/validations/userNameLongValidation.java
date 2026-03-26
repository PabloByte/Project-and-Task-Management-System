package com.beforesecurity.beforesecurity.validations;

import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class userNameLongValidation implements ConstraintValidator<Longvalidations , String> {

        private int min;
        private int max;
        private String message;

  @Override
    public void initialize(Longvalidations annotation) {
        this.min = annotation.min();
        this.max = annotation.max();
        this.message = annotation.message();
    }
        





        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {

                if(value == null || value.trim().isEmpty() ){
                        buildMessage(context, "el campo no puede estar vacio");
                        return  false;
                        
                }else{

                        int length = value.trim().length();

                        if(length < min){

                        buildMessage(context, "el tamaño minimo es "+ min + "caracteres");
                        return  false;
                        }

                         if(length >max){

                        buildMessage(context, "el tamaño maximo es "+ max + "caracteres");

                                  return  false;
                        }
                     return true;   

                }
        }

         private void buildMessage(ConstraintValidatorContext context, String msg) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(msg)
               .addConstraintViolation();
    }



        

}
