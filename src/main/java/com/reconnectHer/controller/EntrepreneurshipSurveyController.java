package com.reconnectHer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reconnectHer.module.EntrepreneurshipSurvey;
import com.reconnectHer.services.EntrepreneurshipServices;

import jakarta.validation.Valid;

@Controller
public class EntrepreneurshipSurveyController {
	
	@Autowired
	private EntrepreneurshipServices eservice;
	
	@GetMapping("/EntrepreneurshipSurvey")
	public String regEntrepreneurship(Model model) {
		model.addAttribute("entrepreneurshipSurvey", new EntrepreneurshipSurvey());
		return "EntrepreneurshipSurveyReg";
	}
	
	
	@PostMapping("/entrepreneurshipstatus")
	public String getStatus(@Valid @ModelAttribute("entrepreneurshipSurvey") EntrepreneurshipSurvey entrepreneurshipSurvey, BindingResult bindResult) {
		System.out.println(bindResult.getAllErrors());
		if(bindResult.hasErrors()) {
			return "EntrepreneurshipSurveyReg";
		}
		eservice.saveRegistred(entrepreneurshipSurvey);
		 return "DashBoard";
	}
}
