package br.unb.bdm.neo4j.repositories;

import java.util.Collection;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.unb.bdm.neo4j.domain.Candidate;

@RepositoryRestResource(collectionResourceRel = "candidates", path = "candidates")
public interface CandidateRepository extends GraphRepository<Candidate>{

	Candidate findByName(@Param("name") String name);

	Candidate findByCnpj(@Param("cnpj") String cnpj);

	Collection<Candidate> findByNameContaining(@Param("name") String name);

	@Query("MATCH (c:Candidate)-[r:MEMBER_OF]->(p:Party initials:{initials}) RETURN c,r,p LIMIT {limit}")
	Collection<Candidate> findByParty(@Param("initials") String initials, @Param("limit") int limit);

	@Query("MATCH (c:Candidate)-[r:RUNS_FOR_PRESIDENT_IN]-(s:State initials:'BR') RETURN c,r,s LIMIT {limit}")
	Collection<Candidate> findPresidentCandidates(@Param("limit") int limit);

	@Query("MATCH (c:Candidate)-[r:RUNS_FOR_GOVERNOR_IN]-(s:State initials:{initials}) RETURN c,r,s LIMIT {limit}")
	Collection<Candidate> findGovernorCandidatesByState(@Param("initials") String initials, @Param("limit") int limit);

	@Query("MATCH (c:Candidate)-[r:RUNS_FOR_SENATOR_IN]-(s:State initials:{initials}) RETURN c,r,s LIMIT {limit}")
	Collection<Candidate> findSenatorCandidatesByState(@Param("initials") String initials, @Param("limit") int limit);

	@Query("MATCH (c:Candidate)-[r:RUNS_FOR_FEDERAL_DEPUTY_IN]-(s:State initials:{initials}) RETURN c,r,s LIMIT {limit}")
	Collection<Candidate> findFederalDeputyCandidatesByState(@Param("initials") String initials,
			@Param("limit") int limit);

	@Query("MATCH (c:Candidate)-[r:RUNS_FOR_STATE_DEPUTY_IN]-(s:State initials:{initials}) RETURN c,r,s LIMIT {limit}")
	Collection<Candidate> findStateDeputyCandidatesByState(@Param("initials") String initials,
			@Param("limit") int limit);

	@Query("MATCH (c:Candidate)-[r:RUNS_FOR_DISTRICT_DEPUTY_IN]-(s:State initials:{initials}) RETURN c,r,s LIMIT {limit}")
	Collection<Candidate> findDistrictDeputyCandidatesByState(@Param("initials") String initials,
			@Param("limit") int limit);


	@Query("MATCH (m:Candidate)<-[r:DONATES_TO]-(a) RETURN m,r,a LIMIT {limit}")
	Collection<Candidate> graph(@Param("limit") int limit);
}
