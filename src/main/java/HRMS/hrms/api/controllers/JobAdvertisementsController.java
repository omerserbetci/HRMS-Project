package HRMS.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.business.abstracts.JobAdvertisementService;
import HRMS.hrms.core.utilities.results.DataResult;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisement>> getAllActive(){
		return this.jobAdvertisementService.getAllActive();
	}
	
	@GetMapping("/getAllActiveByDeadline")
	public DataResult<List<JobAdvertisement>> getAllActiveByDeadlineDate(){
		return this.jobAdvertisementService.getAllActiveByDeadlineDate();
	}
	
	@GetMapping("/getAllByEmployer")
	public DataResult<List<JobAdvertisement>> getAllByEmployer(int employerId){
		return this.jobAdvertisementService.getAllByEmployer(employerId);
	}
	
	@GetMapping("/setAdvertStatus")
	public Result setJobAdvertisementStatus(boolean active, int id) {
		return this.jobAdvertisementService.setJobAdvertisementStatus(active, id);
	}
}
