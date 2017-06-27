package br.unb.bdm.neo4j.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unb.bdm.neo4j.domain.Candidate;
import br.unb.bdm.neo4j.repositories.CandidateRepository;

@Service
public class CandidateService {

	@Autowired
	CandidateRepository candidateRepository;

	private Map<String, Object> toD3Format(Collection<Candidate> candidates) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> rels = new ArrayList<>();
		int i = 0;
		Iterator<Candidate> result = candidates.iterator();
//		while (result.hasNext()) {
//			Candidate candidate = result.next();
//			nodes.add(map("name", candidate.getName(), "label", "candidate"));
//			int target = i;
//			i++;
//			for (Donation receivedDonation : candidate.getReceivedDonations()) {
//
//				Donor donorInstance = receivedDonation.getDonor();
//				Map<String, Object> donor = null;
//				if (donorInstance instanceof Company) {
//					donor = map("id", ((Company) receivedDonation.getDonor()).getCnpj(), "label", "Company");
//				} else if (donorInstance instanceof Person) {
//					donor = map("id", ((Person) receivedDonation.getDonor()).getCpf(), "label", "Person");
//				} else if (donorInstance instanceof Candidate) {
//					donor = map("id", ((Candidate) receivedDonation.getDonor()).getCnpj(), "label", "Candidate");
//				} else if (donorInstance instanceof Directory) {
//					donor = map("id", ((Directory) receivedDonation.getDonor()).getCnpj(), "label", "Directory");
//				} else if (donorInstance instanceof FinancialCommittee) {
//					donor = map("id", ((FinancialCommittee) receivedDonation.getDonor()).getCnpj(), "label",
//							"FinancialCommittee");
//				}
//				int source = nodes.indexOf(donor);
//				if (source == -1) {
//					nodes.add(donor);
//					source = i++;
//				}
//				rels.add(map("source", source, "target", target));
//			}
//		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

//	@Transactional(readOnly = true)
//	public Map<String, Object> graph(int limit) {
//		Collection<Candidate> result = candidateRepository.graph(limit);
//		return toD3Format(result);
//	}
	
//	public Map<String, Object>  getByParty(String initials) {
//				Collection<Candidate> result = candidateRepository.findByParty(initials, 0);
//		return toD3Format(result);
//	}
}
