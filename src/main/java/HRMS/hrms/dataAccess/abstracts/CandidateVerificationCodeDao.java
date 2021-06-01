package HRMS.hrms.dataAccess.abstracts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import HRMS.hrms.entities.concretes.CandidateVerificationCode;

public interface CandidateVerificationCodeDao extends JpaRepository<CandidateVerificationCode, Integer>{

	@Modifying
	@Transactional
	@Query("update VerificationCode set confirmed = true where id =:id")
	public void verifyVerificationCodeFromEMail(@Param("id") int id);
	
	public CandidateVerificationCode findById(int id);
	
}
