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
 * @author Mark Angrish
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cpf")
@NodeEntity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of={"cpf", "name"})
@ToString
public class Person implements Donor {

	@GraphId private Long graphId;

	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private String cpf;

	@Getter
	@Setter
	@NonNull
	private String name;

	@Relationship(type = "DONATES_TO", direction = Relationship.OUTGOING)
	private List<Donation> givenDonations = new ArrayList<>();

}
