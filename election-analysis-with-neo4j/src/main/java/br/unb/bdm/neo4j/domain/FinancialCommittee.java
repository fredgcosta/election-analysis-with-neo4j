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
public class FinancialCommittee implements Donor, Donee {

	@GraphId private Long graphId;
	
	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private Long id;
	@Getter
	@Setter
	@NonNull
	private String cnpj;
	@Getter
	@Setter
	@NonNull
	private String type;

	@Relationship(type = "DONATES_TO", direction = Relationship.INCOMING)
	private List<Donation> receivedDonations = new ArrayList<>();

	@Relationship(type = "DONATES_TO", direction = Relationship.OUTGOING)
	private List<Donation> givenDonations = new ArrayList<>();
}
