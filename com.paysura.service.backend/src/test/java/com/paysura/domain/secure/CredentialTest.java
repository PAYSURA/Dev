package com.paysura.domain.secure;

import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 */
public class CredentialTest extends TestCase {

	private static final String SECURE_PWD_TEST1234 = "2bbe0c48b91a7d1b8a6753a8b9cbe1db16b84379f3f91fe115621284df7a48f1cd71e9beb90ea614c7bd924250aa9e446a866725e685a65df5d139a5cd180dc9";

	public void testSecuredPassword() {
		Credential credential = new Credential("test@test.de", "test1234");
		assertNotEquals(credential.getPassword(), "test1234");
		assertEquals(credential.getPassword(), CredentialTest.SECURE_PWD_TEST1234);
	}

}
