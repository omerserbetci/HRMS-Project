package HRMS.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import HRMS.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	public JobAdvertisement findById(int id);
	
	public List<JobAdvertisement> findByActiveTrue();
	
	public List<JobAdvertisement> findByEmployer_Id(int employerId);
	
	@Modifying
	@Transactional
	@Query("update JobAdvertisement set active =:active where id =:id")
	public void setJobAdvertisementStatus(boolean active, int id);
	
}
