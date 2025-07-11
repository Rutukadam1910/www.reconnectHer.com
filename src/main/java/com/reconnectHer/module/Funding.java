package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funding {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
	
	private String platformName;
	
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Funding [id=" + id + ", platformName=" + platformName + ", description=" + description + "]";
	}

	public Funding(int id, String platformName, String description) {
		super();
		this.id = id;
		this.platformName = platformName;
		this.description = description;
	}

	public Funding() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
