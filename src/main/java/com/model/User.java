package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@Entity @ToString
@Table(name="user")
@EqualsAndHashCode(exclude={"firstName", "lastName"})
public class User {
	@Id @Column(name="email")
	private String email;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	@Column(name="passwd")
	private String passwd;
	
	public User(String firstName, String lastName, String email, String passwd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwd = passwd;
	}
	public User() {
		
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
