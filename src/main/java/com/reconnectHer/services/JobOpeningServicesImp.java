package com.reconnectHer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.JobOpeningRepo;
import com.reconnectHer.module.JobOpening;

@Service
public class JobOpeningServicesImp implements JobOpeningServices{

	@Autowired
	private JobOpeningRepo jobOpenRepo;
	@Override
	public JobOpening saveNew(JobOpening jobOpening) {
		// TODO Auto-generated method stub
		return jobOpenRepo.save(jobOpening);
	}

	@Override
	public List<JobOpening> jobOpenList() {
		// TODO Auto-generated method stub
		List<JobOpening>findAll=jobOpenRepo.findAll();
		return findAll;
	}

	@Override
	public JobOpening updateJobOpen(JobOpening jobOpening) {
		// TODO Auto-generated method stub
		return jobOpenRepo.save(jobOpening);
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		jobOpenRepo.deleteById(id);
		
	}

	@Override
	public JobOpening findByID(int id) {
		// TODO Auto-generated method stub
		Optional <JobOpening>findById=jobOpenRepo.findById(id);
		JobOpening jobOpen=findById.get();
		return jobOpen;
	}

	@Override
    public List<JobOpening> recommendJobs(String primarySkills) {
        List<JobOpening> allJobs = jobOpenList();
        List<JobOpening> recommendedJobs = new ArrayList<>();

        for (JobOpening job : allJobs) {
            if (job.getRequiredSkill().toLowerCase().contains(primarySkills.toLowerCase())) {
                recommendedJobs.add(job);
            }
        }
        return recommendedJobs;
    }

}
