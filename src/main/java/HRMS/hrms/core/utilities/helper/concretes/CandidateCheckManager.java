package HRMS.hrms.core.utilities.helper.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.core.utilities.helper.abstracts.CandidateCheckService;
import HRMS.hrms.core.utilities.helper.abstracts.MernisCheckService;
import HRMS.hrms.core.utilities.results.ErrorResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.dataAccess.abstracts.CandidateDao;
import HRMS.hrms.entities.concretes.Candidate;

@Service
public class CandidateCheckManager implements CandidateCheckService{

	private MernisCheckService mernisCheckService;
	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateCheckManager(MernisCheckService mernisCheckService, CandidateDao candidateDao) {
		this.mernisCheckService = mernisCheckService;
		this.candidateDao = candidateDao;
	}
	
	@Override
	public Result isAllFieldsFilled(Candidate candidate) {
		if (candidate.getName().equals("") || candidate.getName() == null ||
			candidate.getSurname().equals("") || candidate.getSurname() == null ||
			candidate.getIdentityNumber().equals("") || candidate.getIdentityNumber() == null ||
			candidate.getDateOBirth() == null ||
			candidate.getEmail().equals("") || candidate.getEmail() == null ||
			candidate.getPassword().equals("") || candidate.getPassword() == null) {
			
				return new ErrorResult("Tüm alanlar doldurulmalıdır.");
			}
		return null;
	}

	@Override
	public Result isMernisCheckSuccess(Candidate candidate) {
		if(!mernisCheckService.checkIfRealPerson
				(candidate.getIdentityNumber(), candidate.getName(), candidate.getSurname(), candidate.getDateOBirth().getYear())) {
			
			return new ErrorResult("Kullanıcı mernisten doğrulanamadı.");
		}
		return null;
	}

	@Override
	public Result isEMailNotUsedBefore(String email) {
		Candidate candidate = candidateDao.findByEmail(email);
		if (candidate != null) {
			return new ErrorResult("E-Mail adres sistemde zaten kayıtlı!");
		}
		return null;
	}

	@Override
	public Result isIdentityNumberNotRecordedBefore(String identityNumber) {
		Candidate candidate = candidateDao.findByIdentityNumber(identityNumber);
		if (candidate != null) {
			
			return new ErrorResult("Aynı TC ye sahip kayıt mevcuttur.");
		}
		return null;
	}

}
