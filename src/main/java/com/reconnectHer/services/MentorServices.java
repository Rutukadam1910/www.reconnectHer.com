package com.reconnectHer.services;

import java.util.List;

import com.reconnectHer.module.Mentor;

public interface MentorServices {
	
    public Mentor saveMentor(Mentor mentor);
	
	public List<Mentor> MentorList();
	
	public Mentor updateMentor(Mentor mentor);
	
	public void deleteById(int id);
	
	public Mentor findByID(int id);


}
