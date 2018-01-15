package com.paysura.domain.user.bill;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@NodeEntity
@Data
public class Bill {
	
	@GraphId
	private Long id;

}
