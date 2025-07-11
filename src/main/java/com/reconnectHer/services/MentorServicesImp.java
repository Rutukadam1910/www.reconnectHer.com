package com.reconnectHer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.MentorRepo;
import com.reconnectHer.module.Mentor;

@Service
public class MentorServicesImp implements MentorServices{

	@Autowired
	private MentorRepo mentorRepo;

	@Override
	public Mentor saveMentor(Mentor mentor) {
		return mentorRepo.save(mentor);
	}

	@Override
	public List<Mentor> MentorList() {
		List<Mentor> all = mentorRepo.findAll();
		return all;
	}

	@Override
	public Mentor updateMentor(Mentor mentor) {
		return mentorRepo.save(mentor);
	}

	@Override
	public void deleteById(int id) {
		mentorRepo.deleteById(id);
	}

	@Override
	public Mentor findByID(int id) {
		Optional<Mentor> byId = mentorRepo.findById(id);
		Mentor mentor = byId.get();
		return mentor;	
		}

}
