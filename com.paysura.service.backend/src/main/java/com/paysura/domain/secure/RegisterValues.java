/**
 * 
 */
package com.paysura.domain.secure;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.paysura.domain.user.address.Address;
import com.paysura.util.secure.SecureUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RegisterValues extends Credential {

	private static final long serialVersionUID = 1L;
	private Address address;

	/**
	 * No-arg constructor.
	 */
	public RegisterValues() {
		this(null, null, null);
	}

	/**
	 * Two param arguments
	 * 
	 * @param email
	 *            The email address.
	 * @param password
	 *            The password.
	 * @param address
	 *            The {@link Address} object.
	 */
	@JsonCreator
	public RegisterValues(final @JsonProperty("email") String email,
			final @JsonProperty(value = "password") String password, final @JsonProperty("address") Address address) {
		this.setEmail(email);
		this.setPassword(SecureUtil.hashPassword(password));
		this.setAddress(address);
	}

	public interface Existing {
	}

	public interface New {
	}

}
