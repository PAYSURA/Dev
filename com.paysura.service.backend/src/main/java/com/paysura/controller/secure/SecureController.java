/**
 * 
 */
package com.paysura.controller.secure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paysura.domain.secure.Credential;
import com.paysura.domain.user.User;
import com.paysura.service.user.UserRepository;
import com.paysura.util.secure.SecureUtil;

import lombok.Data;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
@Data
@RestController
@RequestMapping("/secure")
public class SecureController {

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(SecureController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>("Hello from Secure Controller", HttpStatus.OK);
	}

	/**
	 * Checks the {@link Credential} inside the body HTTP POST request and perform
	 * an login action.
	 * 
	 * @param credential
	 *            The credentials.
	 * @return {@link User} if successfull, null else.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> login(@Validated(Credential.Existing.class) @RequestBody final Credential credential) {
		return ResponseEntity
				.ok(this.userRepository.findUserByEmailAndPassword(credential.getEmail(), credential.getPassword()));
	}

	/**
	 * Inserts an new entry in the database based on the {@link Credential}'s. If an
	 * {@link User} entry is already available within the email address the request
	 * will fail.
	 * 
	 * @param credential
	 *            The credentials.
	 * @return True if success, false else.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Boolean> register(@Validated(Credential.New.class) @RequestBody final Credential credential) {
		User dbCheck = this.userRepository.findUserByEmail(credential.getEmail());
		ResponseEntity<Boolean> response;
		if (dbCheck != null) {
			LOGGER.warn("Cannot create user with email {}, because entry is already in database",
					credential.getEmail());
			response = ResponseEntity.badRequest().body(false);
		} else {
			User user = new User(credential);
			user.setToken(SecureUtil.generateSecureUserToken());
			boolean result = this.userRepository.save(user) != null;
			if (result) {
				LOGGER.info("User with email address {} has been registered successful", credential.getEmail());
				response = ResponseEntity.ok(true);
			} else {
				LOGGER.error("User with email address {} has been not registered successful", credential.getEmail());
				response = ResponseEntity.badRequest().body(false);
			}
		}

		return response;
	}

}
