/**
 * 
 */
package com.paysura.controller.shop.productgroup;

import java.util.ArrayList;
import java.util.List;

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
import com.paysura.domain.shop.product.ProductGroup;
import com.paysura.domain.shop.product.json.ProductGroupJson;
import com.paysura.service.product.ProductGroupRepository;
import com.paysura.util.jwt.JWTUtil;

import lombok.Data;

/**
 * @author abaklizki
 * @since 21.01.2018
 * @version 1.0
 *
 */
@Data
@RestController
@RequestMapping("/productgroup")
public class ProductGroupController {

	@Autowired
	private ProductGroupRepository productGroupRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductGroupController.class);

	/**
	 * Global "say hello" function.
	 * 
	 * @return String with "hello"
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>("Hello from Product Group Controller", HttpStatus.OK);
	}

	/**
	 * Finds all {@link Product}'s inside the database and returns them.
	 * 
	 * @return {@link List} of {@link Product}.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductGroup>> allProductGroups() {
		return ResponseEntity.ok(this.productGroupRepository.findAll());
	}

	/**
	 * Adds an {@link ProductGroup} into the database.
	 * 
	 * @return {@link List} of {@link Product}.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<ProductGroup>> addNewProductGroup(@RequestBody ProductGroupJson input,
			final @RequestHeader(value = "Authorization") String auth) {
		JWTUtil.isTokenValid(auth);
		ResponseEntity<List<ProductGroup>> result;
		List<ProductGroup> group = this.productGroupRepository.findAll();
		if (this.containsName(group, input.getProductGroupName())) {
			LOGGER.warn("ProductGroup already in the list {}", input.getProductGroupName());
			result = ResponseEntity.ok(new ArrayList<>());
		} else {
			try {
				this.productGroupRepository.save(new ProductGroup(input.getProductGroupName()));
				result = ResponseEntity.ok(group);
			} catch (final Exception e) {
				LOGGER.error("Error while saving new prodcut group", e);
				result = ResponseEntity.badRequest().body(new ArrayList<>());
			}
		}
		return result;

	}

	/**
	 * Checks if an productGroupName is inside a List.
	 * 
	 * @param list
	 *            The list.
	 * @param name
	 *            The name of the productgroup.
	 * @return True, if success, false else.
	 */
	private boolean containsName(final List<ProductGroup> list, final String name) {
		return list.stream().filter(o -> o.getProductGroupName().equals(name)).findFirst().isPresent();
	}

	/**
	 * Search for one special {@link Product} within it's internal id.
	 * 
	 * @param id
	 *            The id of the product.
	 * @return {@link Product} or null.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/findProductGroup/{productGroupName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ProductGroup> findProductById(final @PathVariable("productGroupName") String name) {
		if (name == null || name.isEmpty()) {
			return ResponseEntity.badRequest().body(null);
		} else {
			return ResponseEntity.ok(this.productGroupRepository.findOneByProductGroupName(name));
		}
	}
}
