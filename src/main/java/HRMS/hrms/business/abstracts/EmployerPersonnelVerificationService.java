package HRMS.hrms.business.abstracts;

import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Employer;

public interface EmployerPersonnelVerificationService {

	public Result waitForPersonnelVerifying(Employer employer);
	
	public Result verifyEmployerWithPersonnel(int personnelId, String empEmail);
	
}
