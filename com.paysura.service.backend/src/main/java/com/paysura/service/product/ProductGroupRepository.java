/**
 * 
 */
package com.paysura.service.product;

import java.util.List;

import org.springframework.data.neo4j.repository.GraphRepository;

import com.paysura.domain.shop.product.ProductGroup;

/**
 * @author abaklizki
 * @since 21.01.2018
 * @version 1.0
 *
 */
public interface ProductGroupRepository extends GraphRepository<ProductGroup> {

	/**
	 * Finds all {@link ProductGroup}s.
	 * 
	 * @return {@link List} of {@link ProductGroup}.
	 */
	List<ProductGroup> findAll();

	/**
	 * Search for a specific {@link ProductGroup} within it's name.
	 * 
	 * @param productGroupName
	 *            The name of the group.
	 * @return {@link ProductGroup} if success, null else.
	 */
	ProductGroup findOneByProductGroupName(final String productGroupName);

}
