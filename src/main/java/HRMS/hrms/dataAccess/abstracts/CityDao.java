package HRMS.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMS.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

	public List<City> findByOrderByCityName();
	
}
