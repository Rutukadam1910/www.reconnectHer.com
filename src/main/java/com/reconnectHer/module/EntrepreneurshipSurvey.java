package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EntrepreneurshipSurvey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String domain;
	
	private String needs;
	
	private String community;
	
	private String sustainable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getNeeds() {
		return needs;
	}

	public void setNeeds(String needs) {
		this.needs = needs;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getSustainable() {
		return sustainable;
	}

	public void setSustainable(String sustainable) {
		this.sustainable = sustainable;
	}

	public EntrepreneurshipSurvey(int id, String domain, String needs, String community, String sustainable) {
		super();
		this.id = id;
		this.domain = domain;
		this.needs = needs;
		this.community = community;
		this.sustainable = sustainable;
	}

	@Override
	public String toString() {
		return "EntrepreneurshipSurvey [id=" + id + ", domain=" + domain + ", needs=" + needs + ", community="
				+ community + ", sustainable=" + sustainable + "]";
	}

	public EntrepreneurshipSurvey() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
