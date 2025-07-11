package com.reconnectHer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reconnectHer.dao.FundingRepo;
import com.reconnectHer.module.Funding;
@Service
public class FundingServicesImp implements FundingServices{
	
	@Autowired
	private FundingRepo fundRepo;
    
	@Override
	public Funding saveFunding(Funding Funding) {
		// TODO Auto-generated method stub
		return fundRepo.save(Funding);
	}
	
	@Override
	public List<Funding> FundingList() {
		List<Funding> findAll = fundRepo.findAll();
		return findAll;
	}
	
	@Override
	public void deleteById(int id) {
		fundRepo.deleteById(id);
	}

	@Override
	public Funding findById(int id) {
		Optional<Funding> findById= fundRepo.findById(id);
		Funding funding = findById.get();

		return funding;
	}

	@Override
	public Funding updateFunding(Funding funding) {
		// TODO Auto-generated method stub
		return fundRepo.save(funding);
	}

}


