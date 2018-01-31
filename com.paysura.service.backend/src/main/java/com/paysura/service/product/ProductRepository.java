/**
 * 
 */
package com.paysura.service.product;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.paysura.domain.shop.product.Product;

/**
 * @author abaklizki
 * @since 21.01.2018
 * @version 1.0
 *
 */
public interface ProductRepository extends GraphRepository<Product> {

	/**
	 * Search for all {@link Product}'s.
	 * 
	 * @return Products.
	 */
	List<Product> findAll();

	/**
	 * Search for an {@link Product} within it's product name.
	 * 
	 * @param productName
	 *            The name of the product.
	 * @return {@link Product} if success, null else.
	 */
	Product findProductByProductName(final String productName);

}
