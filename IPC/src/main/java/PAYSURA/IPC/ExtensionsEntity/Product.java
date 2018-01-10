package PAYSURA.IPC.ExtensionsEntity;

public class Product {
	

	private String id;
	
	private String productName;
	
	private double commission;
	
	private double rateFiat;

	private float rateBtc;
	
	private float rateETH;
	
	private float rateIPC;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getRateFiat() {
		return rateFiat;
	}

	public void setRateFiat(double rateFiat) {
		this.rateFiat = rateFiat;
	}

	public float getRateETH() {
		return rateETH;
	}

	public void setRateETH(float rateETH) {
		this.rateETH = rateETH;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getRateBtc() {
		return rateBtc;
	}

	public void setRateBtc(float rateBtc) {
		this.rateBtc = rateBtc;
	}

	public float getRateIPC() {
		return rateIPC;
	}

	public void setRateIPC(float rateIPC) {
		this.rateIPC = rateIPC;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

}
