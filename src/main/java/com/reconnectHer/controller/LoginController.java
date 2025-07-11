package com.reconnectHer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reconnectHer.module.Login;
import com.reconnectHer.module.Register;
import com.reconnectHer.services.RegisterServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {

//	private Repo repo;

	@Autowired
	private RegisterServices regServices;
	
//	public LoginController(Repo repo) {
//		super();
//		this.repo = repo;
//	}

	@GetMapping("/loginWomen")
	public String getLogin(Model model) {
		model.addAttribute("login", new Login());
		return "womenLogin";
	}

	@PostMapping("/loginStatus")
    public String getlogStatus(@Valid @ModelAttribute("login") Login login, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "womenLogin";
        }

        Register user = regServices.findByUsername(login.getUsername());
        if (user != null && user.getPassword().equals(login.getPassword())) {
            session.setAttribute("loggedInUserId", user.getId());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Enter Valid Username and Password");
            return "womenLogin";
        }
    }
	
	
}
