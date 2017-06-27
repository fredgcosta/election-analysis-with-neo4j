package br.unb.bdm.neo4j.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "receipt")
@RelationshipEntity(type = "DONATES_TO")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "receipt", "ammount", "date" })
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
	private BigDecimal ammount;

	@Getter
	@Setter
	@NonNull
	private Date date;

	@StartNode
	@Getter
	@Setter
	private Donor donor;

	@EndNode
	@Getter
	@Setter
	private Donee donee;
}
