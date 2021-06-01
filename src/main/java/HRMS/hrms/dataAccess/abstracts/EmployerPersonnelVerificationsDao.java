package HRMS.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import HRMS.hrms.entities.concretes.EmployerPersonnelVerification;
import HRMS.hrms.entities.concretes.Personnel;

public interface EmployerPersonnelVerificationsDao extends JpaRepository<EmployerPersonnelVerification, Integer>{

	public EmployerPersonnelVerification findByEmployer_Website(String website);
	
	@Modifying
	@Transactional
	@Query("update PersonnelVerification set confirmed = true, personnel =:personnel where id =:id")
	public void verifyEmployerByPersonnel(Personnel personnel, int id);
	
}
