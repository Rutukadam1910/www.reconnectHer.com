package com.reconnectHer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reconnectHer.dao.ContactUsRepo;
import com.reconnectHer.module.ContactUs;


@Service
public class ContactUsServiceImpl  implements ContactUsServices{
@Autowired
	private ContactUsRepo contactUsRepo;

@Override
public ContactUs saveRegistered(ContactUs contactus) {
	// TODO Auto-generated method stub
	return contactUsRepo.save(contactus);
}

@Override
public List<ContactUs> contactUsList() {
	// TODO Auto-generated method stub
List<ContactUs>findAll=contactUsRepo.findAll();
	return findAll;
}

@Override
public void deleteById(int id) {
	// TODO Auto-generated method stub
	contactUsRepo.deleteById(id);
}

@Override
public ContactUs findById(int id) {
	// TODO Auto-generated method stub
	Optional<ContactUs>findById=contactUsRepo.findById(id);
	ContactUs contactUs=findById.get();
	return contactUs;
}

@Override
public ContactUs updateContactUs(ContactUs contactus) {
	// TODO Auto-generated method stub
	return contactUsRepo.save(contactus);
}


}
