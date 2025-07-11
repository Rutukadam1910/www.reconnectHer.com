package com.reconnectHer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reconnectHer.module.Community;
import com.reconnectHer.module.JobOpening;
import com.reconnectHer.module.SuccessStory;
import com.reconnectHer.services.CommunityServices;
import com.reconnectHer.services.JobOpeningServices;
import com.reconnectHer.services.JobSurveyServices;
import com.reconnectHer.services.RoadmapService;
import com.reconnectHer.services.SuccessStoryServices;

@Controller
public class CareerSupportController {

    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    private CommunityServices cs;

    @Autowired
    private JobOpeningServices oj;

    @Autowired
    private SuccessStoryServices ss;

    @Autowired
    private JobSurveyServices js;

    @PostMapping("/careerSupport")
    public String getCareerSupport(@RequestParam("careerOption") String careerOption, Model model) {
        String roadmap = roadmapService.fetchRoadmap(careerOption);

        model.addAttribute("roadmap", roadmap);
        model.addAttribute("selectedCareerOption", careerOption);

        List<Community> list = cs.communityList();
        model.addAttribute("community", list);

        List<JobOpening> joblist = oj.jobOpenList();
        model.addAttribute("jobOpenList", joblist);

        List<SuccessStory> storylist = ss.SuccessStoryList();
        model.addAttribute("storylist", storylist);

        return "dashboard";
    }
}
