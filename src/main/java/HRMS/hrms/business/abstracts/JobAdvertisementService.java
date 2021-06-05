package HRMS.hrms.business.abstracts;

import java.util.List;

import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	public Result add(JobAdvertisement jobAdvertisement);
	
	public DataResult<List<JobAdvertisement>> getAll();
	
	public DataResult<List<JobAdvertisement>> getAllActive();
	
	public DataResult<List<JobAdvertisement>> getAllActiveByDeadlineDate();
	
	public DataResult<List<JobAdvertisement>> getAllByEmployer(int employerId);
	
	public Result setJobAdvertisementStatus(boolean active, int id);
	
}
