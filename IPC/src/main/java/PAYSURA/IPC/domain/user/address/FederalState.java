/**
 * 
 */
package PAYSURA.IPC.domain.user.address;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import PAYSURA.IPC.util.type.RelationshipType;
import lombok.Data;

/**
 * @author abaklizki
 * @since 12.01.2018
 * @version 1.0
 */
@NodeEntity
@Data
public class FederalState {

	@GraphId
	private Long id;

	@Relationship(type = RelationshipType.BELONGS_TO, direction = Relationship.INCOMING)
	@Property(name = "country")
	private Country country;

	@Property(name = "name")
	private String name;

	/**
	 * No-arg constructor.
	 */
	public FederalState() {
		this(null, "");
	}

	/**
	 * Two arg constructor.
	 * 
	 * @param country
	 *            The country, which the FS belongs to
	 * @param name
	 *            The name of the FS
	 */
	public FederalState(final Country country, final String name) {
		super();
		this.setCountry(country);
		this.setName(name);
	}
}
