package com.model;

public class UserDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String token;
	
	public UserDTO() {
	}
	
	public UserDTO(String firstName, String lastName, String email, String token) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.token = token;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;	
	}
	
	public void setEmail(String email) {
			this.email = email;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	}
}
