package com.model;

import javax.persistence.*;


/**
 * Classe do Objeto Usuario
 */
@Entity
public class Usuario {
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String passwd;

	/**
	 * Método construtor do Usuario
	 * @param firstName recebe o primeiro nome do Usuario
	 * @param lastName recebe o ultimo nome do Usuario
	 * @param email recebe o email do Usuario
	 * @param passwd recebe a senha do Usuario
	 */
	public Usuario(String firstName, String lastName, String email, String passwd) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.passwd = passwd;

	}
	
	public Usuario() {
		
	}

	/**
	 * Método get do primeiro nome
	 * @return retorna o primeiro nome
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Método de retorno do ultimo nome
	 * @return retorna o ultimo nome
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Método de retorno da senha do Usuario
	 * @return retorna a senha do Usuario
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * Método de retorno do email do Usuario
	 * @return retorna o email do Usuario
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Método de edição do primeiro nome do Usuario
	 * @param firstName recebe o nome do Usuario
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Método de edição do ultimo nome do Usuario
	 * @param lastName recebe o ultimo nome do Usuario a ser editado
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Método de edição da senha do Usuario
	 * @param passwd recebe a nova senha do Usuario
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
