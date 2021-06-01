package HRMS.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.business.abstracts.CandidateServise;
import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidate")
public class CandidatesController {

	private CandidateServise candidateServis;
	
	public CandidatesController(CandidateServise candidateServise) {
		this.candidateServis = candidateServise;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateServis.getAll();
	}
	
	@GetMapping("/getbyemail")
	public DataResult<Candidate> getByEmail(@RequestParam String email) {
		return this.candidateServis.getByEmail(email);
	}
	
	@PostMapping("/add")
	public Result addNewCandidate(@RequestBody Candidate candidate) {
		return this.candidateServis.add(candidate);
	}
	
}
