package com.beforesecurity.beforesecurity.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy=UniqueEmailValidations.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {



String message() default "{El email ya existe en la base de datos}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };











}
