package br.unb.bdm.neo4j.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Frederico Costa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@RelationshipEntity(type = "DONATES_TO")
public class Donation {

	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	private BigDecimal ammount;

	@Getter
	@Setter
	private Date date;

	@StartNode
	@Getter
	@Setter
	private Donor donor;

	@EndNode
	@Getter
	@Setter
	private Donee donee;

	public Donation() {
		// TODO Auto-generated constructor stub
	}

}
