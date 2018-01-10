package PAYSURA.IPC.Entity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class User {

	@GraphId
	Long id;

	@Property(name = "SmartContractAdress")
	private String scAdresse;

	@Property(name = "bills")
	private double[] bills;

	@Property(name = "IPC")
	private float ipc_values;

	public String getScAdresse() {
		return scAdresse;
	}

	public void setScAdresse(String scAdresse) {
		this.scAdresse = scAdresse;
	}

	public double[] getBills() {
		return bills;
	}

	public void setBills(double[] bills) {
		this.bills = bills;
	}

	public float getIpc_values() {
		return ipc_values;
	}

	public void setIpc_values(float ipc_values) {
		this.ipc_values = ipc_values;
	}

}
