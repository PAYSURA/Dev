package PAYSURA.IPC.Entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import PAYSURA.IPC.ExtensionsEntity.Product;

@NodeEntity
public class RewardPool {

	@GraphId
	Long id;

	@Property(name = "Users")
	private long customers;

	@Property(name = "Products")
	private Product[] products;
}
