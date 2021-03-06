package br.unb.bdm.neo4j.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.unb.bdm.neo4j.domain.Directory;

@RepositoryRestResource(collectionResourceRel = "directories", path = "directories")
public interface DirectoryRepository extends GraphRepository<Directory> {
}
