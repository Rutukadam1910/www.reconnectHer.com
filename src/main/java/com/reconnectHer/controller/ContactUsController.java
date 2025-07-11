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

import com.reconnectHer.module.ContactUs;
import com.reconnectHer.services.ContactUsServices;

import jakarta.validation.Valid;

@Controller
public class ContactUsController {

    @Autowired
    private ContactUsServices contactUsService;

    @GetMapping("/contactus")
    public String addContactUs(Model model) {
        model.addAttribute("contactus", new ContactUs());
        return "contact";
    }

    @PostMapping("/contactusstatus")
    public String getContactStatus(@Valid @ModelAttribute("contactus") ContactUs contactus, BindingResult bindingResult) {
    	System.out.println(bindingResult.getAllErrors());
      if (bindingResult.hasErrors()) {
           return "contact";
       }

        contactUsService.saveRegistered(contactus);
        return "contact";
    }

    @GetMapping("/contactuslist")
    public String getContactUsList(Model model) {
        List<ContactUs> contactuslist = contactUsService.contactUsList();
        model.addAttribute("contactus", contactuslist);
        return "contactlistData";
    }

    @PostMapping("/contactus/delete")
    public String getContactDelete(@RequestParam("id") int id, Model model) {
        contactUsService.deleteById(id);
        String deleteMessage = "Contact Us service successfully deleted with ID: " + id;
        model.addAttribute("message", deleteMessage);
        return "redirect:/contactuslist";
    }
}
