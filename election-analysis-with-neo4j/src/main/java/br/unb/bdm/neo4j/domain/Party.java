package br.unb.bdm.neo4j.domain;

import java.util.HashSet;
import java.util.Set;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "initials")
@NodeEntity
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of={"id", "name", "initials"})
@ToString
public class Party {

	@GraphId
	private Long graphId;

	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private String id;

	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private String name;

	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private String initials;

	@Relationship(type = "MEMBER_OF", direction = Relationship.INCOMING)
	private Set<Candidate> candidates = new HashSet<>();

	@Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
	private Set<Directory> directories = new HashSet<>();

	@Relationship(type = "BELONGS_TO", direction = Relationship.INCOMING)
	private Set<FinancialCommittee> financialCommittees = new HashSet<>();
}
