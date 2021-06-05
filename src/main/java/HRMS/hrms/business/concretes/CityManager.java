package HRMS.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMS.hrms.business.abstracts.CityService;
import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.core.utilities.results.SuccessDataResult;
import HRMS.hrms.core.utilities.results.SuccessResult;
import HRMS.hrms.dataAccess.abstracts.CityDao;
import HRMS.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	
	
	@Override
	public Result add(City city) {
		cityDao.save(city);
		return new SuccessResult("Şehir bilgisi eklendi. " + city.getCityName());
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Şehirler listelendi.");
	}

	@Override
	public DataResult<List<City>> getAllSorted() {
		return new SuccessDataResult<List<City>>(this.cityDao.findByOrderByCityName(),"Şehirler sıralı şekilde listelendi.");
	}

}
