package com.paysura.domain.secure;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 */
public class CredentialTest extends TestCase {

	private static final String SECURE_PWD_TEST1234 = "cc602288481ccc9e79521501a29502671a762bb75cc146f3646cac438680824d5bad37d2a20560c72c8c01d5ae2c3217fc29b209e4b6f1b05de0993baecd68e6";

	/**
	 * Tests, if the credential will be hashed into SHA-512 successfully.
	 */
	public void testSecuredPassword() {
		Credential credential = new Credential("test@test.de", "test1234");
		assertNotEquals(credential.getPassword(), "test1234");
		assertEquals(credential.getPassword(), CredentialTest.SECURE_PWD_TEST1234);
	}

}
