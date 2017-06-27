package br.unb.bdm.neo4j.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.unb.bdm.neo4j.domain.Candidate;

/**
 * @author pdtyreus
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class CandidateRepositoryTest {

	@Autowired
	private Session session;

	@Autowired
	private CandidateRepository instance;

	public CandidateRepositoryTest() {
	}

	@Before
	public void setUp() {
		Candidate dilma = new Candidate(123L, "123456789","Dilma Vana Rousseff");

		instance.save(dilma);
		
		Candidate dilma2 = new Candidate(1234L,"122323239","Dilma asdasd asdasd");

		instance.save(dilma2);
		
		Candidate dilma3 = new Candidate(1235L,"345345345","Dilma sdf werewr");

		instance.save(dilma3);
	}

	@After
	public void tearDown() {
		session.purgeDatabase();
	}

	/**
	 * Test of testFindByName method, of class CandidateRepository.
	 */
	@Test
	public void testFindByName() {

//		String name = "Dilma Vana Rousseff";
//		Candidate result = instance.findByName(name);
//		assertNotNull(result);
//		assertEquals("Dilma Vana Rousseff", result.getName());
	}

	/**
	 * Test of testFindByNameLike method, of class CandidateRepository.
	 */
	@Test
	public void testFindByNameContaining() {
//		String name = "Dilma";
//		Collection<Candidate> result = instance.findByNameContaining(name);
//		assertNotNull(result);
//		assertEquals(3, result.size());
	}

	/**
	 * Test of graph method, of class MovieRepository.
	 */
	@Test
	public void testGraph() {
//		Collection<Candidate> graph = instance.graph(1);
//
//		assertEquals(0, graph.size());

//		Candidate candidate = graph.iterator().next();

//		assertEquals(1, movie.getRoles().size());
//
//		assertEquals("The Matrix", movie.getTitle());
//		assertEquals("Keanu Reeves", movie.getRoles().iterator().next().getPerson().getName());
	}
}
