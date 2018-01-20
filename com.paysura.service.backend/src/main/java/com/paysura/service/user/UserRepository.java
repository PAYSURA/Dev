/**
 * 
 */
package com.paysura.service.user;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.paysura.domain.user.User;

/**
 * @author abaklizki
 * @since 20.01.2018
 * @version 1.0
 *
 */
public interface UserRepository extends GraphRepository<User> {

	/**
	 * Finds an {@link User} object within the username and password.
	 * 
	 * @param email
	 *            THe email address.
	 * @param password
	 *            The password.
	 * @return {@link User} or null.
	 */
	public User findUserByEmailAndPassword(final String email, final String password);

	/**
	 * Finds an {@link User} within it's email address. This function is only for
	 * validation useful.
	 * 
	 * @param email
	 *            The email address.
	 * @return {@link User} if success, null else.
	 */
	public User findUserByEmail(final String email);
}
