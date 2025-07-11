package com.reconnectHer.services;

import java.util.List;

import com.reconnectHer.module.SuccessStory;

import jakarta.validation.Valid;

public interface SuccessStoryServices {
	
	public SuccessStory saveNew(SuccessStory story);
	
	public List<SuccessStory> SuccessStoryList();
	
	public SuccessStory updateSuccessStory(SuccessStory successStory);
	
	public void deleteById(int id);
	
	public SuccessStory findByID(int id);
}
