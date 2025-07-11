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

import com.reconnectHer.module.Funding;
import com.reconnectHer.services.FundingServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class FundingController {
	
	@Autowired
	private FundingServices fundingservice;
	

	@GetMapping("/fund")
	public String saveFunding(Model model) {
		model.addAttribute("funding", new Funding());
		return "funding";
	}
	
	// save funding platform
	@PostMapping("/fundStatus")
	public String getDonerStatus(@Valid @ModelAttribute("funding") Funding funding, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "funding";
		}
		fundingservice.saveFunding(funding);
		return "fundList";
	}
	
	// to display fund list
	@GetMapping("/allfundList")
	public String getFundList(Model model) {
		List<Funding> funding = fundingservice.FundingList();
		model.addAttribute("funding", funding);
		return "fundList";
		
	}
	
	//To delete funding platform
	@PostMapping("/funding/delete")
	public String getDelete(@RequestParam("id") int id, Model model) {
		fundingservice.deleteById(id);
//		model.addAttribute("message", "Voter Succesfully deleated with Id:"+id);
//		String DeleteMessage="Voter Deleted with Id"+id;
		return "redirect:/allfundList";
		
	}
	
	// to update funding platform
	@GetMapping("/funding/edit")
	public String getEdit(@RequestParam("id") int id , Model model) {
		Funding byId = fundingservice.findById(id);
		model.addAttribute("funding" , byId );
		return "updateFunding";
		
	}
	
	@PostMapping("/saveUpdateFunding")
	public String getUpdate(@Valid @ModelAttribute("funding")Funding funding, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			return "updateFunding";
		}
		fundingservice.updateFunding(funding);
		return "redirect:/allfundList";
		
	}
}