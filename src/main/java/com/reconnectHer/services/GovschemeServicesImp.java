package com.reconnectHer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.GovschemeRepo;
import com.reconnectHer.module.GovScheme;
@Service
public class GovschemeServicesImp implements GovschemeServices {
	@Autowired
	private GovschemeRepo govschemeRepo;

	@Override
	public GovScheme saveScheme(GovScheme govScheme) {
		
		return govschemeRepo.save(govScheme);
	}

	@Override
	public List<GovScheme> schemeList() {
		List<GovScheme> all = govschemeRepo.findAll();
		return all;
		
	}

	@Override
	public GovScheme updatescheme(GovScheme govScheme) {
		return govschemeRepo.save(govScheme);

	}

	@Override
	public void deleteById(int id) {
		govschemeRepo.deleteById(id);
		
	}

	@Override
	public GovScheme findByID(int id) {
		Optional<GovScheme> byId = govschemeRepo.findById(id);
		GovScheme govScheme = byId.get();
		return govScheme;	
	}

}
