package com.beforesecurity.beforesecurity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Component
@Constraint(validatedBy=userNameLongValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface Longvalidations {


String message() default "{the information must be 4 character longer}";
    int min() default 2;
    int max() default 50;

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };



}
