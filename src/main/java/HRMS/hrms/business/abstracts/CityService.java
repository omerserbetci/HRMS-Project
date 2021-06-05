package HRMS.hrms.business.abstracts;

import java.util.List;

import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.City;

public interface CityService {

	public Result add(City city);
	
	public DataResult<List<City>> getAll();
	
	public DataResult<List<City>> getAllSorted();
	
}
