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

import com.reconnectHer.module.Register;
import com.reconnectHer.services.RegisterServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class RegisterController {

	@Autowired
	private RegisterServices rs;
	
	@GetMapping("/registerWomen")
	public String regiWomen(Model model) {
		model.addAttribute("register", new Register());
		return "womenRegister";
	}
	
	@PostMapping("/status")
	public String getStatus(@Valid @ModelAttribute("register") Register register, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "womenRegister";	
		}
		rs.saveRegistered(register);
		return "redirect:/loginWomen";
		
	}
	
	@GetMapping("/reglist")
	public String getRegList(Model model) {
		List<Register> reglist = rs.womenList();
		model.addAttribute("reglist", reglist);
		return "regList";

	}
	@PostMapping("/register/delete")
	public String getRegDelete(@RequestParam("id") int id, Model model) {
		rs.deleteById(id);
		String Deletemessage = "register suceessfully delete with id :" + id;
		model.addAttribute("message", Deletemessage);
		return "redirect:/reglist";

	}

    @GetMapping("/userdetails")
    public String getUserDetails(HttpSession session, Model model) {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null) {
            return "redirect:/loginWomen";
        }

        Register user = rs.findByID(loggedInUserId);
        model.addAttribute("user", user);
        return "profiledetails";
    }

    @GetMapping("/userdetails/edit")
    public String getEditUser(HttpSession session, Model model) {
        Integer loggedInUserId = (Integer) session.getAttribute("loggedInUserId");
        if (loggedInUserId == null) {
            return "redirect:/loginWomen";
        }

        Register edituser = rs.findByID(loggedInUserId);
        model.addAttribute("edituser", edituser);
        return "editprofile";
    }

    @PostMapping("/userdetails/saveupdate")
    public String getUpdate(@Valid @ModelAttribute("edituser") Register edituser, BindingResult br, HttpSession session) {
        if (br.hasErrors()) {
            return "editprofile";
        }
        rs.updateRegister(edituser);
        session.setAttribute("loggedInUserId", edituser.getId());
        return "redirect:/userdetails";
    }
	
}
