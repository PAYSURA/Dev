package PAYSURA.IPC.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import PAYSURA.IPC.domain.shop.product.Product;
import lombok.Data;

@NodeEntity
@Data
public class RewardPool {

	@GraphId
	Long id;

	@Property(name = "Users")
	private long customers;

	@Property(name = "Products")
	private List<Product> products;

	public RewardPool() {
		this(0l, null);
	}

	/**
	 * Advanced Constructor.
	 * 
	 * @param customers
	 *            The customer id.
	 * @param products
	 *            The list of the products.
	 */
	public RewardPool(final long customers, final List<Product> products) {
		super();
		this.customers = customers;
		this.products = products;
	}

}
