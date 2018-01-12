/**
 * 
 */
package PAYSURA.IPC.domain.user.address;

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
	
}
