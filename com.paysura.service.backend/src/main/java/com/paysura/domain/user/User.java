package com.paysura.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.paysura.domain.secure.Credential;
import com.paysura.domain.user.address.Address;
import com.paysura.domain.user.bill.Bill;
import com.paysura.util.type.RelationshipType;

import lombok.Data;

@NodeEntity
@Data
public class User {

	@GraphId
	@Transient
	@JsonIgnoreProperties
	Long id;

	private String token;

	@Relationship(type = RelationshipType.HAS_A, direction = Relationship.UNDIRECTED)
	private Address scAdresse;

	@Relationship(type = RelationshipType.HAS_SOME, direction = Relationship.INCOMING)
	private List<Bill> bills;

	private float ipc_values;

	private String email;
 
	private String password;

	/**
	 * Default constructor.
	 */
	public User() {
		this(new Address(), new ArrayList<Bill>(), 0f);
	}

	/**
	 * Special constructor for login.
	 * 
	 * @param credential
	 *            The credentials.
	 */
	public User(final Credential credential) {
		this.setEmail(credential.getEmail());
		this.setPassword(credential.getPassword());
	}

	/**
	 * Advanced constructor.
	 * 
	 * @param address
	 *            The address entity.
	 * @param bills
	 *            {@link List} of {@link Bill}'s.
	 * @param ipc_values
	 *            The amount of the ipc values.
	 */
	public User(final Address address, final List<Bill> bills, final float ipc_values) {
		this(address, bills, ipc_values, null);
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
	 * @param token
	 *            The token.
	 */
	public User(final Address address, final List<Bill> bills, final float ipc_values, final String token) {
		super();
		this.setScAdresse(address);
		this.setBills(bills);
		this.setIpc_values(ipc_values);
		this.setToken(token);
	}
}
