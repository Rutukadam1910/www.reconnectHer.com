package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
@Entity
public class ContactUs {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int id;
	
	@NotBlank(message=" name cannot be empty")
	@Pattern(regexp="^[a-zA-Z]+$", message="Only letters allowed")
	private String name;
	
	private String email;
	
	@NotBlank(message="subject cannot be empty")
	private String subject;
	
	@NotBlank(message="message cannot be empty")
	private String message;
	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public String toString() {
	return "ContactUs [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message="
			+ message + "]";
}
public ContactUs(int id,
		@NotBlank(message = " name cannot be empty") @Pattern(regexp = "^[a-zA-Z]+$", message = "Only letters allowed") String name,
		String email, @NotBlank(message = "subject cannot be empty") String subject,
		@NotBlank(message = "message cannot be empty") String message) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.subject = subject;
	this.message = message;
}
public ContactUs() {
	super();
	// TODO Auto-generated constructor stub
}


}
