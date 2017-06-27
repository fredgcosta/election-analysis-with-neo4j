package br.unb.bdm.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "initials")
@NodeEntity(label = "State")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "name", "initials" })
@ToString
public class State {

	@GraphId
	private Long graphId;

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
}
