package br.unb.bdm.neo4j.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Frederico Costa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "DONATES_TO")
public class Donation {

	@GraphId
	private Long id;

	private BigDecimal ammount;

	private Date date;

	@StartNode
	private Person donator;

	@EndNode
	private Candidate donee;

	public Donation() {
		// TODO Auto-generated constructor stub
	}

}
