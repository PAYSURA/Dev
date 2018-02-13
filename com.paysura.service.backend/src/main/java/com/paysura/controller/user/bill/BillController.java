/**
 * 
 */
package com.paysura.controller.user.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paysura.service.user.UserRepository;

import lombok.Data;

/**
 * @author abaklizki
 * @since 16.01.2018
 * @version 1.0
 *
 */
@Data
@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Dummy function for the health check.
	 * 
	 * @return {@link ResponseEntity} with the hello string.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		return new ResponseEntity<>("Hello from Bill Controller", HttpStatus.OK);
	}
}
