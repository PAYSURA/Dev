package com.paysura.domain.user.address;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.paysura.util.type.RelationshipType;

import lombok.Data;

@NodeEntity
@Data
public class Address {

	@GraphId
	private Long id;

	private String street;

	private String houseNumber;

	@Relationship(type = RelationshipType.BELONGS_TO, direction = Relationship.INCOMING)
	private FederalState federalState;

	/**
	 * Default constructor.
	 */
	public Address() {
		this("", "", new FederalState());
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param street
	 *            The street.
	 * @param houseNumber
	 *            The house number.
	 * @param federalState
	 *            The federalstate of the address.
	 */
	public Address(final String street, final String houseNumber, final FederalState federalState) {
		super();
		this.setStreet(street);
		this.setHouseNumber(houseNumber);
		this.setFederalState(federalState);
	}

}
