/**
 * 
 */
package com.paysura.exception.JWT;

/**
 * @author abaklizki
 * @since 21.01.2018
 * @version 1.0
 *
 */
public class InvalidJwtTokenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * One-argument constructor.
	 * 
	 * @param message
	 *            The message.
	 */
	public InvalidJwtTokenException(final String message) {
		super(message);
	}
}
