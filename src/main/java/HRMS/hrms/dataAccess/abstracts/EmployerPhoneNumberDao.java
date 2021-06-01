package HRMS.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.hrms.entities.concretes.EmployerPhoneNumber;

public interface EmployerPhoneNumberDao extends JpaRepository<EmployerPhoneNumber, Integer>{

	
	
}
