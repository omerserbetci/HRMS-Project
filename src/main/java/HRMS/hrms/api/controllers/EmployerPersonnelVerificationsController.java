package HRMS.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.business.abstracts.EmployerPersonnelVerificationService;
import HRMS.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employerpersonnelverifications")
public class EmployerPersonnelVerificationsController {

	private EmployerPersonnelVerificationService employerPersonnelVerificationServis;

	@Autowired
	public EmployerPersonnelVerificationsController(
			EmployerPersonnelVerificationService employerPersonnelVerificationServis) {
		super();
		this.employerPersonnelVerificationServis = employerPersonnelVerificationServis;
	}
	
	@PostMapping("/verifyEmployer")
	public Result verifyEmployerWithPersonnel(@RequestParam int personnelId, @RequestParam String empEmail) {
		return this.employerPersonnelVerificationServis.verifyEmployerWithPersonnel(personnelId, empEmail);
	}
	
}
