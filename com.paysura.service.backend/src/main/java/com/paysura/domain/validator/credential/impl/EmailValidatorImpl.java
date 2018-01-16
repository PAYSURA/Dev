/**
 * 
 */
package com.paysura.domain.validator.credential.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.paysura.domain.validator.credential.api.EmailValidator;
import com.paysura.util.secure.SecureUtil;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
public class EmailValidatorImpl implements ConstraintValidator<EmailValidator, String> {

	@Override
	public void initialize(EmailValidator constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.isEmpty())
			return false;

		if (!SecureUtil.isEmailValid(value)) {
			return false;
		}
		return true;
	}
}
