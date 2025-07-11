package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobOpening {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String companyname;
	private String salary;
	private String discription;
	private String link;
	public String requiredSkill;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRequiredSkill() {
		return requiredSkill;
	}
	public void setRequiredSkill(String requiredSkill) {
		this.requiredSkill = requiredSkill;
	}
	public JobOpening(int id, String title, String companyname, String salary, String discription, String link,
			String requiredSkill) {
		super();
		this.id = id;
		this.title = title;
		this.companyname = companyname;
		this.salary = salary;
		this.discription = discription;
		this.link = link;
		this.requiredSkill = requiredSkill;
	}
	public JobOpening() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "JobOpening [id=" + id + ", title=" + title + ", companyname=" + companyname + ", salary=" + salary
				+ ", discription=" + discription + ", link=" + link + ", requiredSkill=" + requiredSkill + "]";
	}
	
	
}
