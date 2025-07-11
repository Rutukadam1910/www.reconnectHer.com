package com.reconnectHer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reconnectHer.module.Community;
import com.reconnectHer.module.SuccessStory;
import com.reconnectHer.services.CommunityServices;
import com.reconnectHer.services.SuccessStoryServices;

@Controller
public class LandingPageController {
	
	@Autowired
	private CommunityServices cs;
	
	@Autowired
	private SuccessStoryServices ss;
	
	@GetMapping("/index")
	public String getIndex() {
		return "index";
		
	}
	
//	@GetMapping("/dashboard")
//	public String getdashboard() {
//		return "DashBoard";
//	}
	
	@GetMapping("/contact")
	public String getCantact() {
		return "contact";
	}
	
	@GetMapping("/testimonial")
	public String getTestimonial(Model model) {
		List<SuccessStory> storylist = ss.SuccessStoryList();
		model.addAttribute("storylist", storylist);
		return "testimonial";
		
	}
	
	@GetMapping("/community")
	public String getCommunity(Model model) {
		
		List<Community> list = cs.communityList();
		model.addAttribute("community", list);

		return "community";
	}
	
}
