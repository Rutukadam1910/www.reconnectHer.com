package com.reconnectHer.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.reconnectHer.module.SuccessStory;
import com.reconnectHer.services.SuccessStoryServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Transactional
@Controller
public class SuccessStoryController { 

    @Autowired
    private SuccessStoryServices storyService;

    //to create successStory
    @GetMapping("/addStory")
    public String addSuccessStory(Model model) {
        model.addAttribute("story", new SuccessStory());
        return "storyForm";
    }

    //to save successStory
    @PostMapping("/storyStatus")
    public String getStatus(@Valid @ModelAttribute("story") SuccessStory story, BindingResult bindingResult, @RequestParam("image") MultipartFile imgfile) {
//        System.out.println(bindingResult.getAllErrors());
//    	if (bindingResult.hasErrors()) {
//            return "storyForm";
//        }
        if (!imgfile.isEmpty()) {				
            try {
                story.setImage(imgfile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return "storyForm";
            }
        }
        storyService.saveNew(story);
        return "redirect:/story/display";
    }
    
    

    //to display success story
    @GetMapping("/story/display")
	public String getAll(Model model) {
		List<SuccessStory> list = storyService.SuccessStoryList();
		model.addAttribute("story", list);
		return "storyList";
	}
	
    @GetMapping("/story/image/{id}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable int id){
    	SuccessStory image = storyService.findByID(id);
    	byte [] storyimage = image.getImage();
    	HttpHeaders header = new HttpHeaders();
    	header.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<>(storyimage, header, HttpStatus.OK);
    	
    }
	//To Delete User by ID
	@PostMapping("/story/delete")
	public String getDelete(@RequestParam("id") int ID, Model model) {
		storyService.deleteById(ID);
		String deleteMessage ="story succesfully deleated with ID:"+ID;
		model.addAttribute("message", deleteMessage);
		return "redirect:/story/display";
	}
	
	//TO update success story
	@GetMapping("/story/edit")
	public String getEdit(@RequestParam("id") int id ,Model model) {
		SuccessStory story=storyService.findByID(id);
		
		model.addAttribute("story",story);
		
	return "updatesuccess";	
	}
	
	
	@PostMapping("/savesuccessupdate")
    public String getUpdate(@Valid @ModelAttribute("story") SuccessStory story, BindingResult bindingResult, @RequestParam("image") MultipartFile imgfile) {
//        if (bindingResult.hasErrors()) {
//            return "updatesuccess";
//        }
        if (!imgfile.isEmpty()) {
            try {
                story.setImage(imgfile.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
                return "updatesuccess";
            }
        }
        storyService.updateSuccessStory(story);
        return "redirect:/story/display";
    }
}
