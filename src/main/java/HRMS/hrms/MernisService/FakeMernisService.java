package HRMS.hrms.MernisService;

public class FakeMernisService {

	public boolean verifyWithIdentityNumber
	(String identityNumber, String name, String surname, int yearOfBorn) {
		
		if (!identityNumber.equals("") && identityNumber != null &&
			!name.equals("") && name != null &&
			!surname.equals("") && surname != null &&
			yearOfBorn > 0) {
			
			return true;
		}
		
		return false;
	}
	
}
