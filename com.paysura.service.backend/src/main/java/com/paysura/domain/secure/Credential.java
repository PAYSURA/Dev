/**
 * 
 */
package com.paysura.domain.secure;

import java.io.Serializable;

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

	private String email;
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
		this.setPassword(SecureUtil.parseSecure(password));
	}

}
