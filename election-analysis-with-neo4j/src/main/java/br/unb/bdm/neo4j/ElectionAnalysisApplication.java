package br.unb.bdm.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Frederico Costa
 * @author Wescley
 * @author Rodrigo
 */
@SpringBootApplication
@EntityScan("br.unb.bdm.neo4j.domain")
public class ElectionAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectionAnalysisApplication.class, args);
	}
}