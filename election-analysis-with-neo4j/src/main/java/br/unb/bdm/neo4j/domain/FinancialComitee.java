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
/**
 * @author Frederico Costa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cnpj")
@NodeEntity
public class FinancialComitee{

	@GraphId
	private Long cnpj;

	private String name;


	@Relationship(type = "DONATES_TO")
	private List<Candidate> candidates = new ArrayList<>();

	@Relationship(type = "DONATES_TO")
	private List<PoliticalParty> parties = new ArrayList<>();

	@Relationship(type = "DONATES_TO")
	private List<FinancialComitee> comitees = new ArrayList<>();

	@Relationship(type = "DONATES_TO", direction = Relationship.INCOMING)
	private List<Donation> donations = new ArrayList<>();

	public FinancialComitee() {
		// TODO Auto-generated constructor stub
	}

}
