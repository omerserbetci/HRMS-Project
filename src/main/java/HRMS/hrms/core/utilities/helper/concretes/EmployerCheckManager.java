package HRMS.hrms.core.utilities.helper.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.core.utilities.helper.abstracts.EmployerCheckService;
import HRMS.hrms.core.utilities.results.ErrorResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.dataAccess.abstracts.EmployerDao;
import HRMS.hrms.entities.concretes.Employer;

@Service
public class EmployerCheckManager implements EmployerCheckService {

	private EmployerDao employerDao;
	
	@Autowired	
	public EmployerCheckManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public Result isAllFieldsFilled(Employer employer, String phoneNumber) {
		if (employer.getCompanyName().equals("") || employer.getCompanyName() == null ||
			employer.getEmail().equals("") || employer.getEmail() == null ||
			employer.getPassword().equals("") || employer.getPassword() == null ||
			phoneNumber.equals("") || phoneNumber == null || phoneNumber.length() < 10) {
			
			return new ErrorResult("Tüm alanlar doldurulmalıdır.");
		}
		return null;
	}

	@Override
	public Result isEmailNotUsedBefor(String email) {
		Employer employer = this.employerDao.findByEmail(email);
		if (employer != null) {
			return new ErrorResult("E posta adresi daha önce kullanılmıştır.");
		}
		
		return null;
	}

}
