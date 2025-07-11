package com.reconnectHer.services;

import java.util.List;


import com.reconnectHer.module.ContactUs;



public interface ContactUsServices {

	
	public ContactUs saveRegistered(ContactUs contactus );
	public List<ContactUs>contactUsList();
	public void deleteById(int id);
	public ContactUs findById(int id);
	
	public ContactUs updateContactUs(ContactUs contactus);
}
