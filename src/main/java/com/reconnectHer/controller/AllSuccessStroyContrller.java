package com.reconnectHer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.reconnectHer.module.SuccessStory;
import com.reconnectHer.services.SuccessStoryServices;

@Controller
public class AllSuccessStroyContrller {

	@Autowired
	private SuccessStoryServices ss;
	
	@GetMapping("/allstories")
	public String getAllSuccessStories(Model model) {
		
		List<SuccessStory> storylist = ss.SuccessStoryList();
		model.addAttribute("storylist", storylist);
		return "allstories";
		
	}
}
