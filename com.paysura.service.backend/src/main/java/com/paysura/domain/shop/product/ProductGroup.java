package com.paysura.domain.shop.product;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.paysura.util.type.RelationshipType;

import lombok.Data;

@NodeEntity
@Data
public class ProductGroup {

	@GraphId
	private Long id;

	private String productGroupName;

	@Relationship(type = RelationshipType.HAS, direction = Relationship.INCOMING)
	private Set<Product> products;

	/**
	 * Default constructor.
	 */
	public ProductGroup() {
		this(new HashSet<>(), "");
	}

	/**
	 * Advanced constructor
	 * 
	 * @param products
	 *            Set of {@link Product}, which belongs to a group.
	 * @param productGroupName
	 *            The name of the product group name.
	 */
	public ProductGroup(final Set<Product> products, final String productGroupName) {
		super();
		this.setProducts(products);
		this.setProductGroupName(productGroupName);
	}

}
