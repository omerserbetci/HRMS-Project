package HRMS.hrms.business.concretes;

import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.EmployerVerificationCodeService;
import HRMS.hrms.core.utilities.helper.concretes.VerificationCodeHelper;
import HRMS.hrms.core.utilities.results.ErrorResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.core.utilities.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.EmployerVerificationCodeDao;
import HRMS.hrms.dataAccess.abstracts.VerificationCodeDao;
import HRMS.hrms.entities.concretes.Employer;
import HRMS.hrms.entities.concretes.EmployerVerificationCode;
import HRMS.hrms.entities.concretes.VerificationCode;

@Service
public class EmployerVerificationCodeManager implements EmployerVerificationCodeService{

	private EmployerVerificationCodeDao employerVerificationCodeDao;
	private VerificationCodeDao verificationCodeDao;
	
	public EmployerVerificationCodeManager(EmployerVerificationCodeDao employerVerificationCodeDao, VerificationCodeDao verificationCodeDao) {
		this.employerVerificationCodeDao = employerVerificationCodeDao;
		this.verificationCodeDao = verificationCodeDao;		
	}
	
	@Override
	public Result sendVerificationCodeWithEmail(Employer employer) {
		EmployerVerificationCode verificationCode = new EmployerVerificationCode(employer);
		verificationCode.setVerificationCode(VerificationCodeHelper.generateCode());
		employerVerificationCodeDao.save(verificationCode);
		return new SuccessResult("Doğrulama kodu " +employer.getEmail()+" adresine gönderildi.");
	}

	@Override
	public Result verifyVerificationCodeFromEMail(String verificationCode) {
		VerificationCode verCode = verificationCodeDao.findByVerificationCode(verificationCode);
		if (verCode != null) {
			EmployerVerificationCode empVerCode = employerVerificationCodeDao.findById(verCode.getId());
			employerVerificationCodeDao.verifyVerificationCodeFromEMail(verCode.getId());
			return new SuccessResult(empVerCode.getEmployer().getEmail()+" mail adresine sahip işverenin e posta doğrulaması başarılı.");
		} else {
			return new ErrorResult("Hatalı doğrulama kodu girdiniz!");
		}
		
	}	
	
}
