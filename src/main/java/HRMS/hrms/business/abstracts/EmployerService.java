package HRMS.hrms.business.abstracts;

import java.util.List;

import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	public DataResult<List<Employer>> getAll();
	
	public Result add(Employer employer, String phoneNumber);

}
