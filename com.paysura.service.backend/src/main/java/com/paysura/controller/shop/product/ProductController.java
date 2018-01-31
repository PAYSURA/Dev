/**
 * 
 */
package com.paysura.controller.shop.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.paysura.domain.shop.product.Product;
import com.paysura.service.product.ProductRepository;

import lombok.Data;

/**
 * @author abaklizki
 * @since 21.01.2018
 * @version 1.0
 *
 */
@Data
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	/**
	 * Global "say hello" function.
	 * 
	 * @return String with "hello"
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>("Hello from Product Controller", HttpStatus.OK);
	}

	/**
	 * Finds all {@link Product}'s inside the database and returns them.
	 * 
	 * @return {@link List} of {@link Product}.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Product>> allProducts() {
		return ResponseEntity.ok(this.productRepository.findAll());
	}

	/**
	 * Search for one special {@link Product} within it's internal id.
	 * 
	 * @param id
	 *            The id of the product.
	 * @return {@link Product} or null.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/findProduct/{productId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Product> findProductById(final @PathVariable("productId") Long id) {
		if (id == null || id < 0) {
			return ResponseEntity.badRequest().body(null);
		} else {
			return ResponseEntity.ok(this.productRepository.findOne(id));
		}
	}

	/**
	 * Removes an {@link Product} within an id.
	 * 
	 * @param id
	 *            The id of the product.
	 * @return True, if success, false else.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Boolean> delete(final @PathVariable("productId") Long id) {
		if (id == null || id < 0) {
			return ResponseEntity.badRequest().body(false);
		} else {
			Product product = this.productRepository.findOne(id);
			if (null == product) {
				LOGGER.error("Cannot delete product with id {} because it is not in the database", id);
				return ResponseEntity.badRequest().body(false);
			} else {
				this.productRepository.delete(product);
				return ResponseEntity.ok(true);
			}
		}
	}

	/**
	 * Search for one special {@link Product} within it's internal id.
	 * 
	 * @param id
	 *            The id of the product.
	 * @return {@link Product} or null.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/findProduct/{productName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Product> findProductByName(final @PathVariable("productName") String name) {
		if (name == null || name.isEmpty()) {
			return ResponseEntity.badRequest().body(null);
		} else {
			return ResponseEntity.ok(this.productRepository.findProductByProductName(name));
		}
	}
}
