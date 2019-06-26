package com.model;

import javax.persistence.*;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe que guardará dados das Disciplinas do sistema
 * @author Beatriz Alice
 *
 */
@Data
@Entity(name = "discipline")
@Table(name = "discipline")
public class Discipline {
	/**
	 * Variável de controle, gerada automaticamente
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor do id 
	private long id;
	private String name;

	@ManyToMany(mappedBy = "enjoiyed")
	private Set<Usuario> userLiked;

	@OneToMany(
			mappedBy = "discipline",
			cascade =  CascadeType.ALL,
			orphanRemoval = true
	)
	private Set<UserToDiscipline> evaluation;

	@OneToMany(
			mappedBy = "discipline",
			cascade = CascadeType.ALL,
			orphanRemoval = true
	)
	private Set<Comment> commentsDiscipline;

	/**
	 * Construtor básico da classe Discipline
	 */
	public Discipline() {

		userLiked = new HashSet<Usuario>();
	}
	
	/**
	 * Construtor da classe Discipline
	 * @param name recebe o nome da disciplina.
	 */
	public Discipline(String name) {

		this.name = name;
	}
	 
	//Métodos getters e setters
	
	/**
	 * método de retorno do nome da Disciplina
	 * @return retorna o nome da disciplina
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Método de retorno do Id da Disciplina
	 * @return id da disciplina
	 */
	public long getId() {
		return this.id;
	}
	
	/**
	 * Método de modificaação do nome da disciplina 
	 * @param name novo nome a ser recebido.
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return this.id + " - " + this.name;
	}

	public Set<Usuario> getUserLiked() {
		return this.userLiked;
	}

	public Set<Comment> getCommentsDiscipline() {
		return commentsDiscipline;
	}

	public Set<UserToDiscipline> getEvaluation() {
		return evaluation;
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}





}
