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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paysura.domain.shop.product.Product;
import com.paysura.domain.user.User;
import com.paysura.domain.user.bill.Bill;
import com.paysura.exception.JWT.InvalidJwtTokenException;
import com.paysura.service.product.ProductRepository;
import com.paysura.service.user.UserRepository;
import com.paysura.util.jwt.JWTUtil;

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

	@Autowired
	private ProductRepository productRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * Dummy function for the health check.
	 * 
	 * @return {@link ResponseEntity} with the hello string.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>("Hello from User Controller", HttpStatus.OK);
	}

	/**
	 * Adds an {@link Product} to an {@link User} within the product id and user
	 * token.
	 * 
	 * @param user_token
	 *            The user token.
	 * @param product_id
	 *            The id of the {@link Product}
	 * @param auth
	 *            The auth header.
	 * @return {@link ResponseEntity} with {@link User} if success, null else.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/addProduct/{user_token}/{product_id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<User> addProductToUser(final @PathVariable("user_token") String user_token,
			final @PathVariable("product_id") Long product_id,
			final @RequestHeader(value = "Authorization") String auth) {
		JWTUtil.isTokenValid(auth);
		ResponseEntity<User> response;
		if (product_id == null || user_token == null || product_id < 0 || user_token.isEmpty()) {
			response = ResponseEntity.badRequest().body(null);
			LOGGER.warn("Cannot add product to user, because the parameter arent valid");
		} else {
			User user = this.userRepository.findUserByToken(user_token);
			Product product = this.productRepository.findOne(product_id);
			if (null == user || null == product) {
				response = ResponseEntity.badRequest().body(null);
				LOGGER.error(
						"Cannot add a product to user with user token '{}' because the user or the product is not in the database",
						user_token);
			} else {
				Bill bill = new Bill(product);
				user.getBills().add(bill);
				this.userRepository.save(user);
				LOGGER.info("Product with id {} has been added to a bill for the user with user token {} successfully.",
						product_id, user_token);
				response = ResponseEntity.ok(user);
			}
		}
		return response;
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
