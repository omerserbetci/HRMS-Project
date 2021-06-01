package HRMS.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.EmployerPersonnelVerificationService;
import HRMS.hrms.business.abstracts.EmployerService;
import HRMS.hrms.business.abstracts.EmployerVerificationCodeService;
import HRMS.hrms.core.utilities.helper.abstracts.EmployerCheckService;
import HRMS.hrms.core.utilities.results.*;
import HRMS.hrms.dataAccess.abstracts.EmployerDao;
import HRMS.hrms.dataAccess.abstracts.EmployerPhoneNumberDao;
import HRMS.hrms.entities.concretes.Employer;
import HRMS.hrms.entities.concretes.EmployerPhoneNumber;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerVerificationCodeService employerVerCodeService;
	private EmployerPersonnelVerificationService employerPerVerService;
	private EmployerPhoneNumberDao empPhoneNumberDao;
	private EmployerCheckService employerCheckService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmployerVerificationCodeService employerVerCodeService,
			EmployerPhoneNumberDao empPhoneNumberDao, EmployerPersonnelVerificationService employerPerVerService,
			EmployerCheckService employerCheckService) {
		this.employerDao = employerDao;
		this.employerVerCodeService = employerVerCodeService;
		this.empPhoneNumberDao = empPhoneNumberDao;
		this.employerPerVerService = employerPerVerService;
		this.employerCheckService = employerCheckService;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşverenler getirildi."); 
	}

	@Override
	public Result add(Employer employer, String phoneNumber) {
		
		if(this.employerCheckService.isAllFieldsFilled(employer, phoneNumber) != null) {
			return this.employerCheckService.isAllFieldsFilled(employer, phoneNumber);
		}
		
		if (this.employerCheckService.isEmailNotUsedBefor(employer.getEmail()) != null) {
			return this.employerCheckService.isEmailNotUsedBefor(employer.getEmail());
		}
		
		this.employerDao.save(employer);
		
		EmployerPhoneNumber number = new EmployerPhoneNumber(employer);
		number.setPhoneNumber(phoneNumber);
		this.empPhoneNumberDao.save(number);
		
		Result resultCode = this.employerVerCodeService.sendVerificationCodeWithEmail(employer);
		
		Result resultPersonel = this.employerPerVerService.waitForPersonnelVerifying(employer);
		
		return new SuccessResult("İşveren eklendi. " + employer.getCompanyName() + " " 
		+ resultCode.getMessage() + " " + resultPersonel.getMessage());
	}

}
