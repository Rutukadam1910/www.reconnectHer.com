package com.reconnectHer.services;

import java.util.List;

import com.reconnectHer.module.JobOpening;

public interface JobOpeningServices {

public JobOpening saveNew(JobOpening jobOpening);
	
	public List<JobOpening> jobOpenList();
	
	public JobOpening updateJobOpen(JobOpening jobOpening);
	
	public void deleteById(int id);
	
	public JobOpening findByID(int id);
	
	public List<JobOpening> recommendJobs(String primarySkill);
}
