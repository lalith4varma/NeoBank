package com.NeoBank.custom_validator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ ElementType.TYPE })
@Constraint(validatedBy = PasswordMatchImpl.class)
public @interface PasswordMatch {
	
	String message() default "*Passwords do not match";
	String firstFieldName();
	String secondFieldName();
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
}
