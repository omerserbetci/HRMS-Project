package HRMS.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.CandidateServise;
import HRMS.hrms.business.abstracts.CandidateVerificationCodeService;
import HRMS.hrms.core.utilities.helper.abstracts.CandidateCheckService;
import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.core.utilities.results.SuccessDataResult;
import HRMS.hrms.core.utilities.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateServise{

	private CandidateDao candidateDao;
	private CandidateVerificationCodeService candidateVerificationService;
	private CandidateCheckService candidateCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, CandidateVerificationCodeService candidateVerificationCodeService, CandidateCheckService candidateCheckService) {
		this.candidateDao = candidateDao;
		this.candidateVerificationService = candidateVerificationCodeService;
		this.candidateCheckService = candidateCheckService;
	}
	
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>
		(this.candidateDao.findAll(),"Adaylar getirildi.");
	}

	@Override
	public DataResult<Candidate> getByEmail(String email) {
		return new SuccessDataResult<Candidate>
		(this.candidateDao.findByEmail(email), "Aday getirildi.");
	}

	@Override
	public Result add(Candidate candidate) {
		if(candidateCheckService.isAllFieldsFilled(candidate) != null) {
			return candidateCheckService.isAllFieldsFilled(candidate);
		}
		
		if(candidateCheckService.isMernisCheckSuccess(candidate) != null) {
			return candidateCheckService.isMernisCheckSuccess(candidate);
		}
		
		if (candidateCheckService.isEMailNotUsedBefore(candidate.getEmail()) != null) {
			return candidateCheckService.isEMailNotUsedBefore(candidate.getEmail());
		}
		
		if (candidateCheckService.isIdentityNumberNotRecordedBefore(candidate.getIdentityNumber()) != null) {
			return candidateCheckService.isIdentityNumberNotRecordedBefore(candidate.getIdentityNumber());
		}
		
		this.candidateDao.save(candidate);
		Result verification = this.candidateVerificationService.sendVerificationCodeWithEMail(candidate);
		return new SuccessResult("Data eklendi: " + candidate.getName() + " " + candidate.getSurname()+"\n"
								+ verification.getMessage());
		
	}

	@Override
	public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>
		(this.candidateDao.findByIdentityNumber(identityNumber),"Aday getirildi.");
	}

}
