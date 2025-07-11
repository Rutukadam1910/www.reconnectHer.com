package com.reconnectHer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.CommunityRepo;
import com.reconnectHer.module.Community;

@Service
public class CommunityServicesImp implements CommunityServices{

	@Autowired
	private CommunityRepo communityRepo;
	
	
	
	public Community saveCommunity(Community community) {
		return communityRepo.save(community);
	}



	@Override
	public List<Community> communityList() {
		List<Community> all = communityRepo.findAll();
		return all;
	}



	@Override
	public Community update(Community community) {
		return communityRepo.save(community);
	}



	@Override
	public void deleteById(int id) {
		communityRepo.deleteById(id);
	}



	@Override
	public Community findByID(int id) {
		Optional<Community> byId = communityRepo.findById(id);
		Community dbcommunity = byId.get();
		return dbcommunity;
	}

}
