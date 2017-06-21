package br.unb.bdm.neo4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.unb.bdm.neo4j.domain.State;


@Repository
public interface StateRepository extends GraphRepository<State> {
	
}
