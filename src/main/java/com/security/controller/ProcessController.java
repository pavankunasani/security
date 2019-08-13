package com.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessController {

	
	@PreAuthorize("hasAnyRole('Admin')")
	@GetMapping("/secure/process-one")
	public String makeProcessOne() {

		return "i am making process one";
	}
	
	@GetMapping("/secure/process-two")
	public String makeProcessTwo() {

		return "i am making process two";
	}
	
	
	@GetMapping("/process-three")
	public String makeProcessThree() {

		return "i am making process three";
	}
	
	

}
