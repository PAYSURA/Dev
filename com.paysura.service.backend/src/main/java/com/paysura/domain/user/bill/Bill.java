package com.paysura.domain.user.bill;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.paysura.domain.shop.product.Product;
import com.paysura.util.type.RelationshipType;

import lombok.Data;

@NodeEntity
@Data
public class Bill {

	@GraphId
	private Long id;

	@Relationship(type = RelationshipType.HAS_A, direction = Relationship.INCOMING)
	private Product product;

	/**
	 * No-arg constructor
	 */
	public Bill() {
		this(null);
	}

	/**
	 * One-arg constructor.
	 * 
	 * @param product
	 *            The {@link Product}.
	 */
	public Bill(final Product product) {
		this.setProduct(product);
	}

}
