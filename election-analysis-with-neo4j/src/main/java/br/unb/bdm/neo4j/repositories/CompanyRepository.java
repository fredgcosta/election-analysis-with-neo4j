package br.unb.bdm.neo4j.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.unb.bdm.neo4j.domain.Company;

@Repository
public interface CompanyRepository extends GraphRepository<Company> {

	Company findByName(@Param("name") String name);

	Company findByCnpj(@Param("cnpj") String cnpj);

	Collection<Company> findByNameLike(@Param("name") String name);

	@Query("MATCH (m:Company)-[r:DONATES_TO]->(a) RETURN m,r,a LIMIT {limit}")
	Collection<Company> graph(@Param("limit") int limit);
}
