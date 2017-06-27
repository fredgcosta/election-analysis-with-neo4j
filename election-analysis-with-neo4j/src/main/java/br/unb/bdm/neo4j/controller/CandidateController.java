package br.unb.bdm.neo4j.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.unb.bdm.neo4j.services.CandidateService;

/**
 * @author Mark Angrish
 */
@RestController("/")
public class CandidateController {

	final CandidateService candidateService;

	@Autowired
	public CandidateController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

//	@RequestMapping("/graph")
//	public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
//		return candidateService.graph(limit == null ? 100 : limit);
//	}
}
