package HRMS.hrms.business.abstracts;

import java.util.List;

import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	public DataResult<List<JobPosition>> getAllPositions();
	
	public Result add(JobPosition jobPosition);
	
}
