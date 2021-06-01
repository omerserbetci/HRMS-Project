package HRMS.hrms.business.abstracts;

import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Employer;

public interface EmployerVerificationCodeService {

	public Result sendVerificationCodeWithEmail(Employer employer);
	
	public Result verifyVerificationCodeFromEMail(String verificationCode);
		
}
