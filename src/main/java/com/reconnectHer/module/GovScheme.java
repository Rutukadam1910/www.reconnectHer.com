package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GovScheme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String schemename;
	private String domain;
	private String sector;
	private String applylink;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchemename() {
		return schemename;
	}
	public void setSchemename(String schemename) {
		this.schemename = schemename;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getApplylink() {
		return applylink;
	}
	public void setApplylink(String applylink) {
		this.applylink = applylink;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "GovScheme [id=" + id + ", schemename=" + schemename + ", domain=" + domain + ", sector=" + sector
				+ ", applylink=" + applylink + ", description=" + description + "]";
	}
	public GovScheme(int id, String schemename, String domain, String sector, String applylink, String description) {
		super();
		this.id = id;
		this.schemename = schemename;
		this.domain = domain;
		this.sector = sector;
		this.applylink = applylink;
		this.description = description;
	}
	public GovScheme() {
		super();
		
	}
	
	

}

