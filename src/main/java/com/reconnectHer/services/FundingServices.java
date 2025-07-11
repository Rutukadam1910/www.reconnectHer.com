package com.reconnectHer.services;

import java.util.List;


import com.reconnectHer.module.Funding;

public interface FundingServices {
    public Funding saveFunding(Funding Funding);
	
	public List<Funding> FundingList();
	
	public void deleteById(int id);
	
	public Funding findById(int id);
	
	public Funding updateFunding(Funding funding); 
}
