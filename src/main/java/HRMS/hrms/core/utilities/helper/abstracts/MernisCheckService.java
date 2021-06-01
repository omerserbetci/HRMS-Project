package HRMS.hrms.core.utilities.helper.abstracts;


public interface MernisCheckService {

	public boolean checkIfRealPerson
	(String identityNumber, String name, String surname, int yearOfBorn);
	
}
