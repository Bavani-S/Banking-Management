package com.banking.management.loanservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

	@GetMapping("/health")
	public String health() {
		return "Loan service is up";
	}
}
