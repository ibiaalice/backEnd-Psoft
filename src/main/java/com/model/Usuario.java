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

	@ManyToMany
	@JoinTable(
			name="liked_course",
			joinColumns = @JoinColumn(name = "user_email"),
			inverseJoinColumns = @JoinColumn(name = "subject_id")
	)
	private Set<Discipline> enjoiyed;

	public Usuario(String firstName, String lastName, String email, String passwd, Set<Discipline> enjoyed) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwd = passwd;

	}

	public Usuario() {
		this.enjoiyed = new HashSet<>();
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

	public Set<Discipline> getEnjoiyed() {
		return enjoiyed;
	}

	public void setEnjoiyed(Set<Discipline> enjoiyed) {
		this.enjoiyed = enjoiyed;
	}

}
