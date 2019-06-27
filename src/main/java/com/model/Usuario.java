package com.model;

import javax.persistence.*;



import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String passwd;



	public Usuario(String firstName, String lastName, String email, String passwd, Set<Discipline> enjoyed) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwd = passwd;

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

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getEmail() {
		return this.email;
	}



}
