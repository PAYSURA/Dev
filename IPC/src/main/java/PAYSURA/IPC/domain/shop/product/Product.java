package PAYSURA.IPC.domain.shop.product;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@NodeEntity
@Data
public class Product {

	@GraphId
	private Long id;

	private String productName;

	private double commission;

	private double rateFiat;

	private float rateBtc;

	private float rateETH;

	private float rateIPC;

	/**
	 * Default constructor.
	 */
	public Product() {
		this("", 0, 0, 0f, 0f, 0f);
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param name
	 *            The name of the product.
	 * @param commission
	 *            The commission of the product.
	 * @param rateFiat
	 *            Fiat rate.
	 * @param rateBtc
	 *            BTC rate.
	 * @param rateETH
	 *            ETH rate.
	 * @param rateIPC
	 *            IPC rate.
	 */
	public Product(final String name, final double commission, final double rateFiat, final float rateBtc,
			final float rateETH, final float rateIPC) {
		super();
		this.setProductName(name);
		this.setCommission(commission);
		this.setRateFiat(rateFiat);
		this.setRateBtc(rateBtc);
		this.setRateETH(rateETH);
		this.setRateIPC(rateIPC);
	}

}
