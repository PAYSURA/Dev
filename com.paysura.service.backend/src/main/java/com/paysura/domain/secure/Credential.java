/**
 * 
 */
package com.paysura.domain.secure;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.paysura.domain.validator.credential.api.EmailValidator;
import com.paysura.util.secure.SecureUtil;

import lombok.Data;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 */
@Data
public class Credential implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int pwdMinLength = 8;
	public static final int pwdMaxLength = 30;

	@NotNull(groups = { Existing.class, New.class })
	@EmailValidator(message = "Email address is not valid", groups = { Existing.class, New.class })
	private String email;

	@NotNull
	@Min(value = Credential.pwdMinLength)
	@Max(value = Credential.pwdMaxLength)
	private String password;

	/**
	 * No-arg constructor.
	 */
	public Credential() {
		this(null, null);
	}

	/**
	 * Two param arguments
	 * 
	 * @param email
	 *            The email address.
	 * @param password
	 *            The password.
	 */
	public Credential(final String email, final String password) {
		this.setEmail(email);
		this.setPassword(SecureUtil.hashPassword(password));
	}

	public interface Existing {
	}

	public interface New {
	}

}
