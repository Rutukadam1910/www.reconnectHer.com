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

import com.reconnectHer.module.GovScheme;
import com.reconnectHer.services.GovschemeServices;

import jakarta.validation.Valid;

@Controller
public class GovSchemeController {
	
	@Autowired
	private GovschemeServices  govschemeServices;
	
	@GetMapping("/addScheme")
	public String addScheme(Model model) {
		model.addAttribute("govScheme",new GovScheme());
		
		return "govSchemeform";
		
	}
	 @PostMapping("/schemeStatus")
	    public String getStatus(@Valid @ModelAttribute("govScheme") GovScheme govScheme, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "govSchemeform";
	        }
	        govschemeServices.saveScheme(govScheme);
	        return "redirect:/schemeList";
	    }
	 @GetMapping("/schemeList")
		public String getschemeList(Model model) {
		List<GovScheme>schemeList=govschemeServices.schemeList();
		model.addAttribute("schemeList",schemeList);

		return "govScheme";

		}
	 @PostMapping("/scheme/delete")
		public String getdelete(@RequestParam("id") int id, Model model) {
		 govschemeServices.deleteById(id);
			String Deletemessage="scheme suceessfully delete with id :"+ id;
			model.addAttribute("message",Deletemessage);
			return "redirect:/schemeList";	
		}
	 @GetMapping("/scheme/edit")
		public String getEdit(@RequestParam("id") int id ,Model model) {
		 GovScheme govScheme=govschemeServices.findByID(id);
			
			model.addAttribute("govScheme",govScheme);
			
		return "updateGovScheme";	
	 }
	 @PostMapping("/govesaveupdate")
		public String getUpdate(@Valid @ModelAttribute("govScheme") GovScheme govScheme ,BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return "updateGovScheme";
				}
			govschemeServices.updatescheme(govScheme);
			return "redirect:/schemeList";
	 }
}
