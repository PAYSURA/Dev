package PAYSURA.IPC.Entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;


@NodeEntity
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getRateDollar() {
		return rateDollar;
	}

	public void setRateDollar(double rateDollar) {
		this.rateDollar = rateDollar;
	}

	public double getRateEuro() {
		return rateEuro;
	}

	public void setRateEuro(double rateEuro) {
		this.rateEuro = rateEuro;
	}

	public double getCommissionPercentage() {
		return commissionPercentage;
	}

	public void setCommissionPercentage(double commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	
	
	
}
