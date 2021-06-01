package HRMS.hrms.business.abstracts;

import java.util.List;

import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Candidate;

public interface CandidateServise {

	DataResult<List<Candidate>> getAll();
	
	DataResult<Candidate> getByEmail(String email);
	
	DataResult<Candidate> getByIdentityNumber(String identityNumber);
	
	Result add(Candidate candidate);
	
	
}
