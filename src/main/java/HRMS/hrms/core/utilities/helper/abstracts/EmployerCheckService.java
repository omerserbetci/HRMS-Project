package HRMS.hrms.core.utilities.helper.abstracts;

import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Employer;

public interface EmployerCheckService {

	public Result isAllFieldsFilled(Employer employer, String phoneNumber);
	
	public Result isEmailNotUsedBefor(String email);
	
	
}
