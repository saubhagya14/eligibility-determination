package com.ies.ed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.ed.service.EdService;

@RestController
public class EdController {

	@Autowired
	EdService edService;
	
	@GetMapping("check-elgibility/{caseNumber}")
	public Object checkEligibilty(Integer caseNumber) {
		return edService.checkEligibility(caseNumber);
	}
}
