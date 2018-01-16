/**
 * 
 */
package com.paysura.util.secure;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
public final class SecureUtil {

	private static final String PREFIX = "";
	private static final String POSTFIX = "";
	private static final String ALG = "SHA-512";
	private static final String ENCODING = "UTF-8";
	private static final Logger LOGGER = LoggerFactory.getLogger(SecureUtil.class);

	/**
	 * Updates an plain text password into an SHA-512 hashed.
	 * 
	 * @param password
	 *            The plain text password.
	 * @return SHA-512 encoded password.
	 */
	public static final String parseSecure(final String password) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance(SecureUtil.ALG);
			md.update(SecureUtil.PREFIX.getBytes(SecureUtil.ENCODING));
			md.update(SecureUtil.POSTFIX.getBytes(SecureUtil.ENCODING));
			byte[] bytes = md.digest(password.getBytes(SecureUtil.ENCODING));
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("Alghorithmn does not exist", e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("THe encoding does not exists", e);
		}
		return generatedPassword;
	}

	/**
	 * Private no-arg constructor.
	 */
	private SecureUtil() {

	}
}
