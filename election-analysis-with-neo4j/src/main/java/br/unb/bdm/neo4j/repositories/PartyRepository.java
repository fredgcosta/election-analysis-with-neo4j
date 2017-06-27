package br.unb.bdm.neo4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.unb.bdm.neo4j.domain.Party;

@RepositoryRestResource(collectionResourceRel = "parties", path = "parties")
public interface PartyRepository extends GraphRepository<Party> {
}
