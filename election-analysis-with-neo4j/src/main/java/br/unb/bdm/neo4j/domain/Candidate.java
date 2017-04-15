package br.unb.bdm.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Frederico Costa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cnpj")
@NodeEntity
public class Candidate{

	@GraphId
	private Long cnpj;

	private String name;

	@Relationship(type = "MEMBER_OF")
	private PoliticalParty politicalParty;
	
	@Relationship(type =  "DONATES_TO", direction = Relationship.INCOMING)
	private List<Donation> donations = new ArrayList<>();

	public Candidate() {
		// TODO Auto-generated constructor stub
	}

}
