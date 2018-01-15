/**
 * 
 */
package com.paysura.domain.user;

import static org.junit.Assert.assertNotEquals;

import java.util.Locale;

import com.paysura.domain.user.address.Address;
import com.paysura.domain.user.address.Country;
import com.paysura.domain.user.address.FederalState;

import junit.framework.TestCase;

/**
 * @author abaklizki
 * @since 12.01.2018
 * @version 1.0
 */
public class UserTest extends TestCase {

	/**
	 * Test, if an user object creation within the address will be done correct.
	 */
	public void testUserCreationSuccess() {
		User user = new User();
		assertNotNull(user);
		assertNotNull(user.getScAdresse());
		assertNull(user.getScAdresse().getFederalState());
	}

	/**
	 * Tests a user creation with a valid federal state and country.
	 */
	public void testUserCreationWithAddress() {
		User user = new User();
		Address address = new Address();
		address.setHouseNumber("1");
		address.setStreet("Teststr.");
		Country country = new Country(Locale.GERMANY);
		FederalState fs = new FederalState(country, "Baden Württemberg");
		address.setFederalState(fs);
		user.setScAdresse(address);
		assertNotNull(user.getScAdresse());
		assertNotEquals("teststr.", user.getScAdresse().getStreet());
		assertEquals("Teststr.", user.getScAdresse().getStreet());
		assertNotNull(user.getScAdresse().getFederalState().getCountry());
		assertEquals(Locale.GERMANY.getCountry(), user.getScAdresse().getFederalState().getCountry().getName());
	}

}
