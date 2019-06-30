package com.model;

/**
 * Classe de apoio para retorno de dados do Usuario
 */
public class UserDTO {
	private String firstName;
	private String lastName;
	private String email;
	private String token;

	/**
	 * Método de construção vazia
	 */
	public UserDTO() {
	}

	/**
	 * Método de construção da classe UserDTO
	 * @param firstName primeiro nome do usuário
	 * @param lastName ultimo nome do usuário
	 * @param email email do usuário
	 * @param token token gerado para login
	 */
	public UserDTO(String firstName, String lastName, String email, String token) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.token = token;
	}

	//Métodos Getters e Setters

	/**
	 * Método get do primeiro nome
	 * @return retorna o primeiro nome do usuário
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Método get do ultimo nome do usuário
	 * @return retorna o ultimo nome do usuário
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Método get de email do usuário
	 * @return retorna o email do usuário
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * retorna o token do usuário
	 * @return retorna um token em String
	 */
	public String getToken() {
		return this.token;
	}

	/**
	 * Edita o primeiro nome da pessoa
	 * @param firstName recebe o primeiro nome
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Edita o segundo nome da pessoa
	 * @param lastName recebe o segundo nome
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Edita o email do usuário
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Edita o token do usuário
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}


	//métodos classicos


	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " - " + this.email;
	}
}