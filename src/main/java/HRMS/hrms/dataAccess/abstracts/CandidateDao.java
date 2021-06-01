package HRMS.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

	public Candidate findByEmail(String email);
	
	public Candidate findByIdentityNumber(String identityNumber);
	
	
}
