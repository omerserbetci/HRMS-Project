package HRMS.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.JobAdvertisementService;
import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.ErrorDataResult;
import HRMS.hrms.core.utilities.results.ErrorResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.core.utilities.results.SuccessDataResult;
import HRMS.hrms.core.utilities.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.EmployerDao;
import HRMS.hrms.dataAccess.abstracts.JobAdvertisementDao;
import HRMS.hrms.entities.concretes.Employer;
import HRMS.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	private EmployerDao employerDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, EmployerDao employerDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.employerDao = employerDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("İş ilanı eklendi. " + jobAdvertisement.getEmployer().getCompanyName() +
				" " + jobAdvertisement.getJobPosition().getJobPosition());
		
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"Tüm iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActive() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByActiveTrue(),"Aktif iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllActiveByDeadlineDate() {
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(Sort.by(Sort.Direction.ASC, "applicationDeadline")),"Tüm iş ilanları listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByEmployer(int employerId) {
		Employer employer = this.employerDao.findById(employerId);
		if (employer != null) {
			return new SuccessDataResult<List<JobAdvertisement>>
			(this.jobAdvertisementDao.findByEmployer_Id(employerId), employer.getCompanyName() + 
					" firmasına ait iş ilanları listelenmiştir.");
		} else {
			return new ErrorDataResult<List<JobAdvertisement>>("İşveren bulunamadı.");
		}
		
	}

	@Override
	public Result setJobAdvertisementStatus(boolean active, int id) {
		JobAdvertisement jobAdvert = this.jobAdvertisementDao.findById(id);
		if (jobAdvert != null) {
			this.jobAdvertisementDao.setJobAdvertisementStatus(active, id);
			return new SuccessResult(jobAdvert.getEmployer().getCompanyName() + " firmasına ait " +
		jobAdvert.getJobPosition().getJobPosition() + " pozisyon durumu değiştirildi. " + active);
		} else {
			return new ErrorResult("İş ilanı bulunamadı.");
		}
	}
	
}
