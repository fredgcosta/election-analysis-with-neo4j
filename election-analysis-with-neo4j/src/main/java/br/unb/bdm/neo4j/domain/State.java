package br.unb.bdm.neo4j.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity(label = "State")
public class State {

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
	private String name;

	@Getter
	@Setter
	@NonNull
	@Index(unique = true)
	private String initials;
}
