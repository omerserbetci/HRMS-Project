package HRMS.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HRMS.hrms.business.abstracts.CandidateVerificationCodeService;
import HRMS.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/candidateverification")
public class CandidateVerificationCodesController {

	private CandidateVerificationCodeService candidateVerificationCodeService;
	
	@Autowired
	public CandidateVerificationCodesController(CandidateVerificationCodeService candidateVerificationCodeService) {
		this.candidateVerificationCodeService = candidateVerificationCodeService;
	}
	
	@PostMapping("/verifycode")
	public Result verifyVerificationCodeFromEMail(@RequestBody String verificationCode) {
		return this.candidateVerificationCodeService.verifyVerificationCodeFromEMail(verificationCode);
	}
	
}
