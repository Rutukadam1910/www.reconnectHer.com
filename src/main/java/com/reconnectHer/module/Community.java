package com.reconnectHer.module;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Community {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String communityname;
	
	private String aboutcommunity;
	
	private String communitylink;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommunityname() {
		return communityname;
	}

	public void setCommunityname(String communityname) {
		this.communityname = communityname;
	}

	public String getAboutcommunity() {
		return aboutcommunity;
	}

	public void setAboutcommunity(String aboutcommunity) {
		this.aboutcommunity = aboutcommunity;
	}

	public String getCommunitylink() {
		return communitylink;
	}

	public void setCommunitylink(String communitylink) {
		this.communitylink = communitylink;
	}

	public Community(int id, String communityname, String aboutcommunity, String communitylink) {
		super();
		this.id = id;
		this.communityname = communityname;
		this.aboutcommunity = aboutcommunity;
		this.communitylink = communitylink;
	}

	public Community() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Community [id=" + id + ", communityname=" + communityname + ", aboutcommunity=" + aboutcommunity
				+ ", communitylink=" + communitylink + "]";
	}

}
