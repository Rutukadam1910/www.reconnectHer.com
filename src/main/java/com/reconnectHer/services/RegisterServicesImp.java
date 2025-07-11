package com.reconnectHer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.RegisterRepo;
import com.reconnectHer.module.Register;

@Service
public class RegisterServicesImp implements RegisterServices{

	@Autowired
	private RegisterRepo registerRepo;
	
	
	public RegisterServicesImp(RegisterRepo registerRepo) {
		super();
		this.registerRepo = registerRepo;
	}


	@Override
	public Register saveRegistered(Register register) {
		// TODO Auto-generated method stub
		return registerRepo.save(register);
	}


	@Override
	public List<Register> womenList() {
		// TODO Auto-generated method stub
		List<Register> findAllWomen= registerRepo.findAll();
		return findAllWomen;
	}


	@Override
	public Register updateRegister(Register register) {
		// TODO Auto-generated method stub
		return registerRepo.save(register) ;
	}


	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		registerRepo.deleteById(id);
	}


	@Override
	public Register findByID(int id) {
		// TODO Auto-generated method stub
		Optional<Register>findbyid=registerRepo.findById(id);
		Register register=findbyid.get();
		return register;
	}
	
	@Override
    public Register findByUsername(String username) {
        return registerRepo.findByUsername(username);
    }

}
