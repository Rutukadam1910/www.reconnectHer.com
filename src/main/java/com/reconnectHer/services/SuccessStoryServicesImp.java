package com.reconnectHer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.controller.SuccessStoryController;
import com.reconnectHer.dao.SuccessStoryRepo;
import com.reconnectHer.module.SuccessStory;

@Service
public class SuccessStoryServicesImp implements SuccessStoryServices{
	
	@Autowired
	private SuccessStoryRepo successrepo;

	
	public SuccessStory saveNew(SuccessStory successStory) {
		return successrepo.save(successStory);
	}

	@Override
	public List<SuccessStory> SuccessStoryList() {
		List<SuccessStory> all = successrepo.findAll();
		return all;
	}

	@Override
	public SuccessStory updateSuccessStory(SuccessStory successStory) {
		return successrepo.save(successStory);
	}

	@Override
	public void deleteById(int id) {
		successrepo.deleteById(id);
	}

	@Override
	public SuccessStory findByID(int id) {
		Optional<SuccessStory> byId = successrepo.findById(id);
		SuccessStory successStory = byId.get();
		return successStory;
	}
	
	
	
	
}
