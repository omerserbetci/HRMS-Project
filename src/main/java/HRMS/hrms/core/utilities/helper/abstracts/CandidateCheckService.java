package HRMS.hrms.core.utilities.helper.abstracts;

import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Candidate;

public interface CandidateCheckService {

	public Result isAllFieldsFilled(Candidate candidate);
	
	public Result isMernisCheckSuccess(Candidate candidate);
	
	public Result isEMailNotUsedBefore(String email);
	
	public Result isIdentityNumberNotRecordedBefore(String identityNumber);
	
}
