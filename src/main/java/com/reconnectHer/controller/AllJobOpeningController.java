package com.reconnectHer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reconnectHer.module.JobOpening;
import com.reconnectHer.services.JobOpeningServices;

@Controller
public class AllJobOpeningController {

	@Autowired
	private JobOpeningServices js;
	
	@GetMapping("/alljobopenings")
	public String getAllJobs(Model model) {
		
		List<JobOpening> joblist = js.jobOpenList();
		model.addAttribute("jobOpenList", joblist);
		
		return "alljobopening";
		
	}
}
