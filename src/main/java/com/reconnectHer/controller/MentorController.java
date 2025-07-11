package com.reconnectHer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.reconnectHer.module.Mentor;
import com.reconnectHer.services.MentorServices;

import jakarta.validation.Valid;

@Controller
public class MentorController {
	
	@Autowired
	private MentorServices mentorServices;
    
	@GetMapping("/addMentor")
	public String addMentor(Model model) {
		model.addAttribute("mentor",new Mentor());
		
		return "mentorform";
		
	}
	

    @PostMapping("/mentorStatus")
    public String getStatus(@Valid @ModelAttribute("mentor") Mentor mentor, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "mentorform";
        }
        mentorServices.saveMentor(mentor);
        return "redirect:/mentorList";
    }
	 
    
    //to display all mentor
	 @GetMapping("/mentorList")
		public String getmentorList(Model model) {
		List<Mentor>mentorList=mentorServices.MentorList();
		model.addAttribute("mentorList",mentorList);

		return "mentor";

		}
		
	 
	 //to delete mentor
		@PostMapping("/mentor/delete")
		public String getdelete(@RequestParam("id") int id, Model model) {
			mentorServices.deleteById(id);
			String Deletemessage="Mentor suceessfully delete with id :"+ id;
			model.addAttribute("message",Deletemessage);
			return "redirect:/mentorList";	
		}
		
		
		//to update mentor
		@GetMapping("/mentor/edit")
		public String getEdit(@RequestParam("id") int id ,Model model) {
			Mentor mentor=mentorServices.findByID(id);
			
			model.addAttribute("mentor",mentor);
			
		return "updatementor";	
		}

		@PostMapping("/savementorupdate")
		public String getUpdate(@Valid @ModelAttribute("mentor") Mentor mentor ,BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return "updatementor";
				}
			mentorServices.updateMentor(mentor);
			return "redirect:/mentorList";
			
		}
		


}