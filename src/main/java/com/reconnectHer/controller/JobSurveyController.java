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
import org.springframework.web.client.RestTemplate;

import com.reconnectHer.module.Community;
import com.reconnectHer.module.JobOpening;
import com.reconnectHer.module.JobSurvey;
import com.reconnectHer.module.SuccessStory;
import com.reconnectHer.services.CommunityServices;
import com.reconnectHer.services.JobOpeningServices;
import com.reconnectHer.services.JobSurveyServices;
import com.reconnectHer.services.SuccessStoryServices;

import jakarta.validation.Valid;

@Controller
public class JobSurveyController {

	@Autowired
	private CommunityServices cs;
	
	@Autowired
	private JobOpeningServices oj;
	
	@Autowired
	private SuccessStoryServices ss;
	
	@Autowired
	private JobSurveyServices js;
	
	@GetMapping("/jobSurvey")
	public String regiJobSurvey(Model model) {
		model.addAttribute("jobsurvey", new JobSurvey());
		return "JobSurveyReg";
		
	}
	
//	@PostMapping("/jobSurveystatus")
//	public String getStatus(@Valid @ModelAttribute("jobsurvey")JobSurvey jobsurvey, BindingResult br) {
//		if(br.hasErrors()) {
//			return "JobSurveyReg";
//		}
//		js.saveJobSurvey(jobsurvey);
//		return "redirect:/dashboard";
//		
//	}
	 @PostMapping("/submitSurvey")
	    public String submitSurvey(@Valid @ModelAttribute("jobsurvey") JobSurvey jobsurvey,
	                               @RequestParam("primarySkills") String primarySkills, 
	                               Model model, BindingResult br) {
	        if (br.hasErrors()) {
	            return "JobSurveyReg";
	        }
	        js.saveJobSurvey(jobsurvey);
	        
	        List<JobOpening> recommendedJobs = oj.recommendJobs(primarySkills);
	        model.addAttribute("recommendedJobs", recommendedJobs);
	        
	        List<Community> list = cs.communityList();
	        model.addAttribute("community", list);
	        
	        List<JobOpening> joblist = oj.jobOpenList();
	        model.addAttribute("jobOpenList", joblist);
	        
	        List<SuccessStory> storylist = ss.SuccessStoryList();
	        model.addAttribute("storylist", storylist);
	        
	        return "dashboard";
	    }	
//	 @PostMapping("/careerSupport")
//	    public String getCareerSupport(@RequestParam("careerOption") String careerOption, Model model) {
//	        String roadmapUrl = "https://roadmap.sh/api/frontend";  // Example URL, update based on selected option
//	        RestTemplate restTemplate = new RestTemplate();
//	        String roadmap = restTemplate.getForObject(roadmapUrl, String.class);
//
//	        model.addAttribute("roadmap", roadmap);
//	        model.addAttribute("selectedCareerOption", careerOption);
//
//	        List<Community> list = cs.communityList();
//	        model.addAttribute("community", list);
//
//	        List<JobOpening> joblist = oj.jobOpenList();
//	        model.addAttribute("jobOpenList", joblist);
//
//	        List<SuccessStory> storylist = ss.SuccessStoryList();
//	        model.addAttribute("storylist", storylist);
//
//	        return "dashboard";
//	    }
}
