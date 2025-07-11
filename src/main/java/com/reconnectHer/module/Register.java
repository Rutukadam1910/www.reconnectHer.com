package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message="First name cannot be empty")
	@Pattern(regexp="^[a-zA-Z]+$", message="Only letters allowed")
	private String firstName;
	
	@NotBlank(message="Last name cannot be empty")
	@Pattern(regexp="^[a-zA-Z]+$", message="Only letters allowed")
	private String lastName;
	
	@NotBlank(message="Contact number cannot be empty")
	@Pattern(regexp="^[0-9]+$", message="Only numbers are allowed")
	private String contactNumber;
	
	@NotBlank(message = "Email cannot be empty")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",message = "Email does not match the required pattern")
	private String email;
	
	
	private String highestQualification;
	
	@NotBlank(message="Adhar number cannot be empty")
	@Pattern(regexp="^[0-9]+$", message="Only numbers are allowed")
	private String adharNumber;
	
	private String username;
	
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public String getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Register(int id, String firstName, String lastName, String contactNumber, String email,
			String highestQualification, String adharNumber, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.highestQualification = highestQualification;
		this.adharNumber = adharNumber;
		this.username = username;
		this.password = password;
	}

	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", email=" + email + ", highestQualification=" + highestQualification
				+ ", adharNumber=" + adharNumber + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
