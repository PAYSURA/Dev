package PAYSURA.IPC.Entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
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

	public String getShopeName() {
		return shopeName;
	}

	public void setShopeName(String shopeName) {
		this.shopeName = shopeName;
	}

	public String getBusinessGenre() {
		return businessGenre;
	}

	public void setBusinessGenre(String businessGenre) {
		this.businessGenre = businessGenre;
	}

	public String getLicencePackage() {
		return licencePackage;
	}

	public void setLicencePackage(String licencePackage) {
		this.licencePackage = licencePackage;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public float getIpc() {
		return ipc;
	}

	public void setIpc(float ipc) {
		this.ipc = ipc;
	}

}
