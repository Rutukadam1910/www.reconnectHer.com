package com.reconnectHer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reconnectHer.module.Community;
import com.reconnectHer.services.CommunityServices;

@Controller
public class AllCommunityController {

	@Autowired
	private CommunityServices cs;
	
	@GetMapping("/allcommunities")
	public String getAllCommunities(Model model) {
		
		List<Community> list = cs.communityList();
		model.addAttribute("community", list);
		return "allcommunity";
		
	}
}
