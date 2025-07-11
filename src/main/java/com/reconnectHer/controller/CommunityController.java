package com.reconnectHer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reconnectHer.module.Community;
import com.reconnectHer.module.JobOpening;
import com.reconnectHer.module.Mentor;
import com.reconnectHer.module.SuccessStory;
import com.reconnectHer.services.CommunityServices;
import com.reconnectHer.services.JobOpeningServices;
import com.reconnectHer.services.SuccessStoryServices;

import jakarta.validation.Valid;

@Controller
public class CommunityController {
	
	@Autowired
	private CommunityServices cs;
	
	@Autowired
	private JobOpeningServices js;
	
	@Autowired
	private SuccessStoryServices ss;
	
	//to create community
	@GetMapping("/addcommunity")
	public String addCommunity(Model model) {
		model.addAttribute("community", new Community());
		return  "communityform";
		
	}
	@GetMapping("/applynow")
	public String applynow(Model model) {
		List<JobOpening> jobopenList =js.jobOpenList();
		model.addAttribute("jobOpenList", new JobOpening());
		return  "applynow";
		
	}
	
	//to save community
	@PostMapping("/addcommunityStatus")
	public String getStatus(@Valid @ModelAttribute("community")Community community, BindingResult br) {
		
		if(br.hasErrors()) {
			return"communityform";
		}
		cs.saveCommunity(community);
		return "redirect:/dashboard";
	}
	
	
	@GetMapping("/dashboard")
	public String getAll(Model model) {
		List<Community> list = cs.communityList();
		model.addAttribute("community", list);
		
		List<JobOpening> joblist = js.jobOpenList();
		model.addAttribute("jobOpenList", joblist);
		
		List<SuccessStory> storylist = ss.SuccessStoryList();
		model.addAttribute("storylist", storylist);
		return "dashboard";
	}
	
	//To display all community
	@GetMapping("/communitylist")
	public String getcommunityList(Model model) {
		List<Community> communitylist=cs.communityList();
		model.addAttribute("community" , communitylist);
		return "communityadmin";
	}
	
	//To Delete Community by ID
	@PostMapping("/community/delete")
	public String getDelete(@RequestParam("id") int ID, Model model) {
		cs.deleteById(ID);
		String deleteMessage ="community succesfully deleated with ID:"+ID;
		model.addAttribute("message", deleteMessage);
		return "redirect:/communitylist";	
	}
	
	
//	@PostMapping("/submitSurvey")
//    public String submitSurvey(@RequestParam("primarySkill") String primarySkill, Model model) {
//        List<JobOpening> recommendedJobs = js.recommendJobs(primarySkill);
//        model.addAttribute("recommendedJobs", recommendedJobs);
//        
//        List<Community> list = cs.communityList();
//        model.addAttribute("community", list);
//        
//        List<JobOpening> joblist = js.jobOpenList();
//        model.addAttribute("jobOpenList", joblist);
//        
//        List<SuccessStory> storylist = ss.SuccessStoryList();
//        model.addAttribute("storylist", storylist);
//        
//        return "dashboard";
//    }
	
	//To update community
	@GetMapping("/community/edit")
	public String getEdit(@RequestParam("id") int id ,Model model) {
		Community byID = cs.findByID(id);
		model.addAttribute("community",byID);
		
		return "updatecommunity";	
	}

	@PostMapping("/newupdate")
	public String getUpdate(@Valid @ModelAttribute("community") Community community ,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "updatecommunity";
			}
		cs.update(community);
		return "redirect:/communitylist";
		
	}
	
	
	
}
