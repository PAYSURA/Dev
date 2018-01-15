/**
 * 
 */
package PAYSURA.IPC.domain.secure;

import java.io.Serializable;

import lombok.Data;

/**
 * @author abaklizki
 * @since 15.01.2018
 * @version 1.0
 *
 */
@Data
public class Credential implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

	/**
	 * No-arg constructor
	 */
	public Credential() {
		this("", "");
	}

	/**
	 * Two-arg constructor.
	 * 
	 * @param email
	 *            The email address.
	 * @param password
	 *            The password.
	 */
	public Credential(final String email, final String password) {
		super();
		this.setEmail(email);
		this.setPassword(password);
	}

}
