package PAYSURA.IPC.entity.user.address;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

import lombok.Data;

@NodeEntity
@Data
public class Address {

	@GraphId
	private Long id;
	
	@Property(name = "street")
	private String street;

	@Property(name = "houseNumber")
	private String houseNumber;

	/**
	 * Default constructor.
	 */
	public Address() {
		this("", "");
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param street
	 *            The street.
	 * @param houseNumber
	 *            The house number.
	 */
	public Address(final String street, final String houseNumber) {
		super();
		this.setStreet(street);
		this.setHouseNumber(houseNumber);
	}

}
