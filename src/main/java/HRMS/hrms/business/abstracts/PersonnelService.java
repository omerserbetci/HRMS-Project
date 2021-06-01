package HRMS.hrms.business.abstracts;

import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Personnel;

public interface PersonnelService {

	public Result add(Personnel personnel);
	
}
