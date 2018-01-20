/**
 * 
 */
package com.paysura.domain.user.address;

import java.util.Locale;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

/**
 * @author abaklizki
 * @since 12.01.2018
 * @version 1.0
 */
@NodeEntity
@Data
public class Country {

	@GraphId
	private Long id;

	private String name;

	/**
	 * Private no arg constructor.
	 */
	public Country() {
		this(Locale.GERMANY);
	}

	/**
	 * One arg constructor.
	 * 
	 * @param name
	 *            The name of the country
	 */
	public Country(final Locale name) {
		super();
		if (null != name) {
			this.setName(name.getCountry());
		}

	}

}
