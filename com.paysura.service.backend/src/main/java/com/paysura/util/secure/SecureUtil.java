/**
 * 
 */
package com.paysura.util.secure;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
public final class SecureUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecureUtil.class);
	private static final String PREFIX = "45.T@2,10kCy";
	private static final String ENCODING = "UTF-8";
	private static final String ALG = "SHA-512";

	/**
	 * Turns an plain text password into an SHA-512 password.
	 * 
	 * @param password
	 *            Plain text password.
	 * @return Hashed Password.
	 */
	public static final String hashPassword(final String password) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance(SecureUtil.ALG);
			md.update(SecureUtil.PREFIX.getBytes(SecureUtil.ENCODING));
			byte[] bytes = md.digest(password.getBytes(SecureUtil.ENCODING));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("No such algorithmn: {}", SecureUtil.ALG, e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("No such encoding: {}", SecureUtil.ENCODING, e);
		}
		return generatedPassword;
	}

	/**
	 * Checks if an email address is valid or not.
	 * 
	 * @param email
	 *            The email address.
	 * @return True, if success, false else.
	 */
	public static boolean isEmailValid(final String email) {
		boolean result = false;
		if (email != null && !email.isEmpty()) {
			try {
				InternetAddress emailAddr = new InternetAddress(email);
				emailAddr.validate();
				result = true;
			} catch (AddressException ex) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * Privaet no-arg construtor.
	 */
	private SecureUtil() {

	}
}
