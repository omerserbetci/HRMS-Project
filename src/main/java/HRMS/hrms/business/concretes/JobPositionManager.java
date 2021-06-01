package HRMS.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.JobPositionService;
import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.ErrorResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.core.utilities.results.SuccessDataResult;
import HRMS.hrms.core.utilities.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.JobPositionDao;
import HRMS.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}


	@Override
	public DataResult<List<JobPosition>> getAllPositions() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Pozisyonlar getirildi.");
		
	}


	@Override
	public Result add(JobPosition jobPosition) {
		if (jobPositionDao.findByJobPosition(jobPosition.getJobPosition()) != null) {
			return new ErrorResult("Pozisyon daha önce eklendi");
		}
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Pozisyon eklendi: " + jobPosition.getJobPosition());
	}

}
