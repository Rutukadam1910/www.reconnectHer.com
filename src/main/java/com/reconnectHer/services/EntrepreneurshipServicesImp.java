package com.reconnectHer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.EntrepreneurshipSurveyRepo;
import com.reconnectHer.module.EntrepreneurshipSurvey;

@Service
public class EntrepreneurshipServicesImp implements EntrepreneurshipServices{

	@Autowired
	private EntrepreneurshipSurveyRepo enRepo;
	
	@Override
	public EntrepreneurshipSurvey saveRegistred(EntrepreneurshipSurvey entrepreneurshipSurvey) {
		return enRepo.save(entrepreneurshipSurvey);
	}

}