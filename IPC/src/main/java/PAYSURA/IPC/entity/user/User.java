package PAYSURA.IPC.entity.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.Address;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import PAYSURA.IPC.entity.user.bill.Bill;
import lombok.Data;

@NodeEntity
@Data
public class User {

	@GraphId
	Long id;

	@Property(name = "SmartContractAdress")
	private Address scAdresse;

	@SuppressWarnings("rawtypes")
	@Property(name = "bills")
	private List[] bills;

	@Property(name = "IPC")
	private float ipc_values;

	/**
	 * Default constructor.
	 */
	public User() {
		this(new Address(), new ArrayList<Bill>(), 0f);
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param adress
	 *            The address entity.
	 * @param bills
	 *            {@link List} of {@link Bill}'s.
	 * @param ipc_values
	 *            The amount of the ipc values.
	 */
	public User(final Address adress, final List<Bill> bills, final float ipc_values) {
		super();
		this.setScAdresse(adress);
	}
}
