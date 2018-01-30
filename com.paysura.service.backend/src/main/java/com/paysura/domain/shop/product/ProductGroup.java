package com.paysura.domain.shop.product;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@NodeEntity
@Data
public class ProductGroup {

	@GraphId
	private Long id;

	private Set<Product> products;

	/**
	 * Default constructor.
	 */
	public ProductGroup() {
		this(new HashSet<>());
	}

	/**
	 * Advanced constructor
	 * 
	 * @param products
	 *            Set of {@link Product}, which belongs to a group.
	 */
	public ProductGroup(final Set<Product> products) {
		super();
		this.setProducts(products);
	}

}
