package com.reconnectHer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminController {
	
	@GetMapping("/adminDash")
	public String getAdmin() {
		return "admin";
	}
	
	@GetMapping("/sucessstory")
	public String getSucessStroy() {
		return "storylist";
		
	}
	
//	@GetMapping("/applynow")
//	public String applyJob() {
//		return "applynow";
//	}
}
