package com.reconnectHer.services;

import java.util.List;

import com.reconnectHer.module.GovScheme;

public interface GovschemeServices {

    public GovScheme saveScheme(GovScheme govScheme);
	
	public List<GovScheme> schemeList();
	
	public GovScheme updatescheme(GovScheme govScheme);
	
	public void deleteById(int id);
	
	public GovScheme findByID(int id);



}
