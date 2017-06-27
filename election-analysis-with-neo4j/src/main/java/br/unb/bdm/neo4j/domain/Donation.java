package br.unb.bdm.neo4j.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "receipt")
@RelationshipEntity(type = "DONATES_TO")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "receipt", "value", "timestamp" })
@ToString
public class Donation {

	@GraphId
	Long graphId;

	@Getter
	@Setter
	@NonNull
	private String receipt;
	
	@Getter
	@Setter
	@NonNull
	private String source;
	
	@Getter
	@Setter
	@NonNull
	private String type;

	@Getter
	@Setter
	@NonNull
	private Double value;

	@Getter
	@Setter
	@NonNull
	private Long timestamp;

	@StartNode
	@Getter
	@Setter
	@JsonIgnore
	private Donor donor;

	@EndNode
	@Getter
	@Setter
	@JsonIgnore
	private Donee donee;
}
