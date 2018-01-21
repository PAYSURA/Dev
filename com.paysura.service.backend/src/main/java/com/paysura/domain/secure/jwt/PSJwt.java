/**
 * 
 */
package com.paysura.domain.secure.jwt;

import java.io.Serializable;

import lombok.Data;

/**
 * @author abaklizki
 * @since 21.01.2018
 * @version 1.0
 */
@Data
public class PSJwt implements Serializable {

	private static final long serialVersionUID = 1L;
	private String token;

	/**
	 * No arg constructor
	 */
	public PSJwt() {
		this(null);
	}

	/**
	 * One-arg constructor.
	 * 
	 * @param token
	 *            The JWT Token.
	 */
	public PSJwt(final String token) {
		super();
		this.setToken(token);
	}

}
