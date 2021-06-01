package HRMS.hrms.business.abstracts;

import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Candidate;

public interface CandidateVerificationCodeService {

	public Result sendVerificationCodeWithEMail(Candidate candidate);
	
	public Result verifyVerificationCodeFromEMail(String verificationCode);
	
}
