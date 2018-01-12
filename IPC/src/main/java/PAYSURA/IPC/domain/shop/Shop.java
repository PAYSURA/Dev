package PAYSURA.IPC.domain.shop;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import lombok.Data;

@NodeEntity
@Data
public class Shop {

	@GraphId
	Long id;

	@Property(name = "Shop")
	private String shopeName;

	@Property(name = "Genre")
	private String businessGenre;

	@Property(name = "Package")
	private String licencePackage;

	@Property(name = "Popularity")
	private int popularity;

	@Property(name = "IPC_Amount")
	private float ipc;

	/**
	 * Empty constructor.
	 */
	public Shop() {
		this("", "", 0, 0);
	}

	/**
	 * Advanced Constructor.
	 * 
	 * @param shopName
	 *            Name of the shop.
	 * @param businessGenre
	 *            Name of the business genre.
	 * @param popularity
	 *            The popularity.
	 * @param ipc
	 *            The amount of IPC's.
	 */
	public Shop(final String shopName, final String businessGenre, final int popularity, final int ipc) {
		super();
		this.setShopeName(shopName);
		this.setBusinessGenre(businessGenre);
		this.setPopularity(popularity);
		this.setIpc(ipc);
	}

}
