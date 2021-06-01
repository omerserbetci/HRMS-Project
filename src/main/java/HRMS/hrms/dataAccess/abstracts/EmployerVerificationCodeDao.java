package HRMS.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import HRMS.hrms.entities.concretes.EmployerVerificationCode;

public interface EmployerVerificationCodeDao extends JpaRepository<EmployerVerificationCode, Integer>{

	@Modifying
	@Transactional
	@Query("update VerificationCode set confirmed = true where id =:id")
	public void verifyVerificationCodeFromEMail(@Param("id") int id);
	
	public EmployerVerificationCode findById(int id);
	
}
