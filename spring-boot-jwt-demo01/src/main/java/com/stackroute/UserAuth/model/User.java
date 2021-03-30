package com.stackroute.UserAuth.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	private String username;
	private String email;
	private String password;
	private String location;
	
	public User() {
		
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String image) {
		this.location = image;
	}

	
	
	
	
}
