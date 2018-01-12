/**
 * 
 */
package PAYSURA.IPC.domain.user.address;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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

	@Relationship(type="BELONGS_TO")
	private Country country;
}
