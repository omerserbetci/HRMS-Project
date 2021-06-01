package HRMS.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.hrms.entities.concretes.Personnel;

public interface PersonnelDao extends JpaRepository<Personnel, Integer>{

	public Personnel findById(int personelId);
	
	public Personnel findByEmail(String email);
	
}
