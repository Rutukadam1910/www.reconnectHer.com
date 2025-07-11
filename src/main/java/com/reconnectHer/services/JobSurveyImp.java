package com.reconnectHer.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.JobSurveyRepo;
import com.reconnectHer.module.JobSurvey;

@Service
public class JobSurveyImp implements JobSurveyServices{

	@Autowired
	private  JobSurveyRepo jobRepo;
	
	
	public JobSurvey saveJobSurvey(JobSurvey jobSurvey) {
		return jobRepo.save(jobSurvey);
	}
	
	 

}
