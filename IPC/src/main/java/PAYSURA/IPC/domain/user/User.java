package PAYSURA.IPC.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import PAYSURA.IPC.domain.user.address.Address;
import PAYSURA.IPC.domain.user.bill.Bill;
import PAYSURA.IPC.util.type.RelationshipType;
import lombok.Data;

@NodeEntity
@Data
public class User {

	@GraphId
	Long id;

	@Property(name = "SmartContractAdress")
	@Relationship(type = RelationshipType.HAS_A, direction = Relationship.UNDIRECTED)
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
