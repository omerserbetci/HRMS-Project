package HRMS.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.EmployerPersonnelVerificationService;
import HRMS.hrms.core.utilities.results.ErrorResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.core.utilities.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.EmployerDao;
import HRMS.hrms.dataAccess.abstracts.EmployerPersonnelVerificationsDao;
import HRMS.hrms.dataAccess.abstracts.PersonnelDao;
import HRMS.hrms.entities.concretes.Employer;
import HRMS.hrms.entities.concretes.EmployerPersonnelVerification;
import HRMS.hrms.entities.concretes.Personnel;

@Service
public class EmployerPersonnelVerificationManager implements EmployerPersonnelVerificationService{

	private EmployerPersonnelVerificationsDao employerPersonnelVerificationsDao;
	private PersonnelDao personnelDao;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerPersonnelVerificationManager
	(EmployerPersonnelVerificationsDao employerPersonnelVerificationsDao, PersonnelDao personnelDao, EmployerDao employerDao) {
		this.employerPersonnelVerificationsDao = employerPersonnelVerificationsDao;
		this.personnelDao = personnelDao;
		this.employerDao = employerDao;
	}
	
	@Override
	public Result verifyEmployerWithPersonnel(int personnelId, String empEmail) {
		Personnel personnel = this.personnelDao.findById(personnelId);
		Employer employer = this.employerDao.findByEmail(empEmail);
		EmployerPersonnelVerification empPerVer = this.employerPersonnelVerificationsDao.findByEmployer_Website(employer.getWebsite());
		if (personnel != null && empPerVer != null) {
			this.employerPersonnelVerificationsDao.verifyEmployerByPersonnel(personnel, empPerVer.getId());
			
			return new SuccessResult(employer.getCompanyName() + " isimli firma " + personnel.getName() +
					" " + personnel.getSurname() + " isimli personel tarafından onaylandı.");
			
		} else {
			return new ErrorResult("Personel veya işveren bulunamadı!");
		}
	}

	@Override
	public Result waitForPersonnelVerifying(Employer employer) {
		EmployerPersonnelVerification empPerVer = new EmployerPersonnelVerification(employer);
		Personnel personnel = this.personnelDao.findById(-1);
		empPerVer.setPersonnel(personnel);
		this.employerPersonnelVerificationsDao.save(empPerVer);
		return new SuccessResult("Personel onayı bekleniyor.");
	}
	
}
