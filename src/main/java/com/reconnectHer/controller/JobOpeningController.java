package com.reconnectHer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reconnectHer.module.JobOpening;
import com.reconnectHer.services.JobOpeningServices;

import jakarta.validation.Valid;

@Controller
public class JobOpeningController {

	@Autowired
	private JobOpeningServices jobOpenService;

	@GetMapping("/addjob")
	public String addJobOpen(Model model) {
		model.addAttribute("jobopen", new JobOpening());
		return "jobopeningform";

	}

	@PostMapping("/jobstatus")
	public String getjobStatus(@Valid @ModelAttribute("jobopen") JobOpening jobOpening, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "jobopeningform";

		}
		jobOpenService.saveNew(jobOpening);

		return "redirect:/jobopenlist";
	}

	@GetMapping("/jobopenlist")
	public String getJobOpenList(Model model) {
		List<JobOpening> jobopenlist = jobOpenService.jobOpenList();
		model.addAttribute("jobopenlist", jobopenlist);
		return "jobopening";

	}

	@PostMapping("/jobopen/delete")
	public String getjobDelete(@RequestParam("id") int id, Model model) {
		jobOpenService.deleteById(id);
		String Deletemessage = "job open suceessfully delete with id :" + id;
		model.addAttribute("message", Deletemessage);
		return "redirect:/jobopenlist";

	}

	@GetMapping("/jobopen/edit")
	public String getEditForm(@RequestParam("id") int id, Model model) {
		JobOpening jobopen = jobOpenService.findByID(id);

		model.addAttribute("jobopen", jobopen);

		return "updatejobopening";

	}

	@PostMapping("/savejobopeningupdate")
	public String getUpdate(@Valid @ModelAttribute("jobopen") JobOpening jobopening, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "updatejobopening";
		}
		jobOpenService.updateJobOpen(jobopening);

		return "redirect:/jobopenlist";

	}
	@GetMapping("jobdetails/{id}")
	public String getJobdetails(@PathVariable("id") int id, Model model) {
		
		JobOpening jobdetails =  jobOpenService.findByID(id);
		model.addAttribute("jobdetails", jobdetails);
		return "applynow";
		
	}

}
