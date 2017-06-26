package br.unb.bdm.neo4j.domain;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Frederico Costa
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Candidate implements Donor, Donee {

	@GraphId private Long graphId;
	
	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private Long id;

	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private String cnpj;

	@Getter
	@Setter
	private String cpf;

	@Getter
	@Setter
	@NonNull
	private String name;

	@Relationship(type = "MEMBER_OF")
	@Getter
	@Setter
	private Party party;

	@Relationship(type = "RUNS_FOR_PRESIDENT_IN")
	private State runsForPresidentIn;
	@Relationship(type = "RUNS_FOR_GOVERNOR_IN")
	private State runsForGovernorIn;
	@Relationship(type = "RUNS_FOR_SENATOR_IN")
	private State runsForSenatorIn;
	@Relationship(type = "RUNS_FOR_FEDERAL_DEPUTY_IN")
	private State runsForFederalDeputyIn;
	@Relationship(type = "RUNS_FOR_STATE_DEPUTY_IN")
	private State runsForStateDeputyIn;
	@Relationship(type = "RUNS_FOR_DISTRICT_DEPUTY_IN")
	private State runsForDistrictDeputyIn;

	@Relationship(type = "DONATES_TO", direction = Relationship.INCOMING)
	@Getter
	@Setter
	private List<Donation> receivedDonations = new ArrayList<>();

	@Relationship(type = "DONATES_TO", direction = Relationship.OUTGOING)
	@Getter
	@Setter
	private List<Donation> givenDonations = new ArrayList<>();
}
