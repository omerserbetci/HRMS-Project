package HRMS.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.business.abstracts.EmployerVerificationCodeService;
import HRMS.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("api/empverification")
public class EmployerVerificationCodeController {

	private EmployerVerificationCodeService employerverCodeService;
	
	@Autowired
	public EmployerVerificationCodeController(EmployerVerificationCodeService employerVerCodeService) {
		this.employerverCodeService = employerVerCodeService;
	}
	
	@PostMapping("/verifyCode")
	public Result verifyVerificationCodeFromEMail(@RequestParam String verificationCode) {
		return employerverCodeService.verifyVerificationCodeFromEMail(verificationCode);
	}
	
}
