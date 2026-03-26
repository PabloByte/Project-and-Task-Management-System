package com.beforesecurity.beforesecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidatorConfig {


        public LocalValidatorFactoryBean validator (){

                return new LocalValidatorFactoryBean();


        }



        









}
