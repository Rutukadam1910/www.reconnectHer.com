package com.reconnectHer.module;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JobSurvey {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String priviousJob ;
	
	private String breakDuration;
	
	private String courses;
	
	private String workMode;
	
	private String primarySkills;
	
	private String secondarySkills;
	
	private String hobbies;
	
	private Date dob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriviousJob() {
		return priviousJob;
	}

	public void setPriviousJob(String priviousJob) {
		this.priviousJob = priviousJob;
	}

	public String getBreakDuration() {
		return breakDuration;
	}

	public void setBreakDuration(String breakDuration) {
		this.breakDuration = breakDuration;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getWorkMode() {
		return workMode;
	}

	public void setWorkMode(String workMode) {
		this.workMode = workMode;
	}

	public String getPrimarySkills() {
		return primarySkills;
	}

	public void setPrimarySkills(String primarySkills) {
		this.primarySkills = primarySkills;
	}

	public String getSecondarySkills() {
		return secondarySkills;
	}

	public void setSecondarySkills(String secondarySkills) {
		this.secondarySkills = secondarySkills;
	}

	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public JobSurvey(int id, String priviousJob, String breakDuration, String courses, String workMode,
			String primarySkills, String secondarySkills, String hobbies, Date dob) {
		super();
		this.id = id;
		this.priviousJob = priviousJob;
		this.breakDuration = breakDuration;
		this.courses = courses;
		this.workMode = workMode;
		this.primarySkills = primarySkills;
		this.secondarySkills = secondarySkills;
		this.hobbies = hobbies;
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "JobSurvey [id=" + id + ", priviousJob=" + priviousJob + ", breakDuration=" + breakDuration
				+ ", courses=" + courses + ", workMode=" + workMode + ", primarySkills=" + primarySkills
				+ ", secondarySkills=" + secondarySkills + ", hobbies=" + hobbies + ", dob=" + dob + "]";
	}

	public JobSurvey() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
}
