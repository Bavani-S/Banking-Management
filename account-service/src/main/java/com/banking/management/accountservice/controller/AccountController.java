package com.banking.management.accountservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	@GetMapping("/health")
	public String health() {
		return "Account service is up";
	}
}
