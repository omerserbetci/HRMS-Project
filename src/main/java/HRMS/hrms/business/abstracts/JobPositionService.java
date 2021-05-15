package HRMS.hrms.business.abstracts;

import java.util.List;

import HRMS.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	public List<JobPosition> getAllPositions();
	
}
