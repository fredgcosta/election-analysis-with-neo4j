package br.unb.bdm.neo4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.unb.bdm.neo4j.domain.Person;

@Repository
public interface PersonRepository extends GraphRepository<Person> {

}
