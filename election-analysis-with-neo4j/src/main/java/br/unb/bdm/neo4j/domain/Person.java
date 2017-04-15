package br.unb.bdm.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Mark Angrish
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cpf")
@NodeEntity
public class Person{

	@GraphId
	private Long cpf;

	private String name;

	@Relationship(type = "DONATES_TO")
	private List<Candidate> candidates = new ArrayList<>();

	@Relationship(type = "DONATES_TO")
	private List<PoliticalParty> parties = new ArrayList<>();

	@Relationship(type = "DONATES_TO")
	private List<FinancialComitee> comitees = new ArrayList<>();

	public Person() {
	}

	public Person(String name) {

		this.name = name;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}
}
