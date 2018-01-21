/**
 * 
 */
package com.paysura.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paysura.domain.secure.Credential;
import com.paysura.domain.secure.RegisterValues;
import com.paysura.domain.secure.jwt.PSJwt;
import com.paysura.domain.user.User;
import com.paysura.exception.JWT.InvalidJwtTokenException;
import com.paysura.service.user.UserRepository;
import com.paysura.util.jwt.JWTUtil;
import com.paysura.util.secure.SecureUtil;

import io.jsonwebtoken.Jwt;
import lombok.Data;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
@Data
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>("Hello from User Controller", HttpStatus.OK);
	}

	/**
	 * Updates email, password and address from the {@link User}. The credentials
	 * email and password will be used for fetching the User inside the database.
	 * 
	 * @param user
	 *            The new user parameter inside the body.
	 * @param auth
	 *            The Authentication value inside the header.
	 * @return {@link ResponseEntity<User>} or null
	 * @throws InvalidJwtTokenException
	 *             If {@link Jwt} token is not valid.
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> update(final @RequestBody User user,
			final @RequestHeader(value = "Authorization") String auth) {
		JWTUtil.isTokenValid(auth);
		User result;
		if (null == user || user.getEmail() == null || user.getEmail().isEmpty()) {
			LOGGER.info("Cannot update user because entity or required parameters are empty");
			result = null;
		} else {
			User userDb = this.userRepository.findUserByEmailAndPassword(user.getEmail(), user.getPassword());
			if (userDb == null) {
				LOGGER.error("Cannot update user because not found in the database");
				result = null;
			} else {
				userDb.setEmail(user.getEmail());
				userDb.setPassword(user.getPassword());
				userDb.setScAdresse(user.getScAdresse());
				this.userRepository.save(userDb);
				result = userDb;
				LOGGER.info("User with email {} has been updated successful", user.getEmail());
			}
		}
		return ResponseEntity.ok(result);
	}
}
