package HRMS.hrms.core.utilities.adapters;

import org.springframework.stereotype.Service;

import HRMS.hrms.MernisService.FakeMernisService;
import HRMS.hrms.core.utilities.helper.abstracts.MernisCheckService;

@Service
public class MernisAdapter implements MernisCheckService{

	FakeMernisService mernisServis = new FakeMernisService();

	@Override
	public boolean checkIfRealPerson
	(String identityNumber, String name, String surname, int yearOfBorn) {
		return mernisServis.verifyWithIdentityNumber
				(identityNumber, name, surname, yearOfBorn);
	}
	
	
	
}
