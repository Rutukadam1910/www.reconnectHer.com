package com.reconnectHer.services;

import java.util.List;

import com.reconnectHer.module.Community;

public interface CommunityServices {

	public Community saveCommunity(Community community);
	
	public List<Community> communityList();
	
	public Community update(Community community);
	
	public void deleteById(int id);
	
	public Community findByID(int id);
}
