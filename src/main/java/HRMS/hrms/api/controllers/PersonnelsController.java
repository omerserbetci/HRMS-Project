package HRMS.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.business.abstracts.PersonnelService;
import HRMS.hrms.core.utilities.results.Result;
import HRMS.hrms.entities.concretes.Personnel;

@RestController
@RequestMapping("api/personnels")
public class PersonnelsController {

	private PersonnelService personnelService;

	@Autowired
	public PersonnelsController(PersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}
	
	@PostMapping("/add")
	public Result addPersonnel(@RequestBody Personnel personnel) {
		return this.personnelService.add(personnel);
	}
	
}
