package com.reconnectHer.services;

import java.util.List;

import com.reconnectHer.module.Register;

public interface RegisterServices {

	public Register saveRegistered(Register register);
	
	public List<Register> womenList();
	
	public Register updateRegister(Register register);
	
	public void deleteById(int id);
	
	public Register findByID(int id);
	
	// Method to find user by username
	   public Register findByUsername(String username);
}
