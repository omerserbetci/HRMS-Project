package HRMS.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.CandidateVerificationCodeService;
import HRMS.hrms.core.utilities.helper.concretes.VerificationCodeHelper;
import HRMS.hrms.core.utilities.results.ErrorResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.core.utilities.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.CandidateVerificationCodeDao;
import HRMS.hrms.dataAccess.abstracts.VerificationCodeDao;
import HRMS.hrms.entities.concretes.Candidate;
import HRMS.hrms.entities.concretes.CandidateVerificationCode;
import HRMS.hrms.entities.concretes.VerificationCode;

@Service
public class CandidateVerificationCodeManager implements CandidateVerificationCodeService{

	private CandidateVerificationCodeDao candidateVerificationCodeDao;
	private VerificationCodeDao verificationCodeDao;
	
	@Autowired
	public CandidateVerificationCodeManager(CandidateVerificationCodeDao candidateVerificationCodeDao, VerificationCodeDao verificationCodeDao) {
		this.candidateVerificationCodeDao = candidateVerificationCodeDao;
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result sendVerificationCodeWithEMail(Candidate candidate) {
		CandidateVerificationCode verificationCode = new CandidateVerificationCode(candidate);
		verificationCode.setVerificationCode(VerificationCodeHelper.generateCode());
		candidateVerificationCodeDao.save(verificationCode);
		return new SuccessResult("E posta doğrulama kodu "+verificationCode.getCandidate().getEmail()+" adresine gönderildi.");
	}
	
	@Override
	public Result verifyVerificationCodeFromEMail(String verificationCode) {
		VerificationCode verCode = verificationCodeDao.findByVerificationCode(verificationCode);
		if (verCode != null) {
			CandidateVerificationCode canVerCode = candidateVerificationCodeDao.findById(verCode.getId());
			candidateVerificationCodeDao.verifyVerificationCodeFromEMail(canVerCode.getId());
			return new SuccessResult(canVerCode.getCandidate().getEmail()+" mail adresine sahip hesabın üyeliği onaylandı.");
		} else {
			return new ErrorResult("Hatalı doğrulama kodu girdiniz!");
		}
		
	}
	
	
	
}
