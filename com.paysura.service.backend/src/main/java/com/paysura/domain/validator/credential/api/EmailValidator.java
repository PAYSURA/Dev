/**
 * 
 */
package com.paysura.domain.validator.credential.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.paysura.domain.validator.credential.impl.EmailValidatorImpl;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { EmailValidatorImpl.class })
public @interface EmailValidator {

	String message() default "Email is not valid";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String email() default "";

}