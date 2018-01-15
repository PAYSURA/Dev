package com.paysura.domain.shop;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import lombok.Data;

@NodeEntity
@Data
public class ProductShop {

	@GraphId
	Long id;

	@Property(name = "productName")
	private String productName;

	@Property(name = "rateDollar")
	private double rateDollar;

	@Property(name = "rateEuro")
	private double rateEuro;

	@Property(name = "commission")
	private double commissionPercentage;

	/**
	 * Default constructor.
	 */
	public ProductShop() {
		this("", 0, 0, 0);
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param productName
	 *            The name of the product.
	 * @param rateDollar
	 *            The rate of the product in Euro.
	 * @param rateEuro
	 *            The rate of the product in dollar.
	 * @param commissionPercentage
	 *            The commission.
	 */
	public ProductShop(final String productName, final double rateDollar, final double rateEuro,
			final double commissionPercentage) {
		super();
		this.productName = productName;
		this.rateDollar = rateDollar;
		this.rateEuro = rateEuro;
		this.commissionPercentage = commissionPercentage;
	}

}
