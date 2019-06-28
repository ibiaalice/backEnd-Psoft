package com.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe que guardará dados das Disciplinas do sistema
 * @author Beatriz Alice
 *
 */
@Entity
@Table(name = "discipline")
public class Discipline {
	/**
	 * Variável de controle, gerada automaticamente
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor do id
	private long id;
	@Column(name = "name")
	private String name;

	//@Column(name = "likes")
	@ManyToMany
	private HashSet<String> userLiked;

	/**
	 * Construtor básico da classe Discipline
	 */
	public Discipline() {
		userLiked = new HashSet<String>();
	}

	/**
	 * Construtor da classe Discipline
	 * @param name recebe o nome da disciplina.
	 */
	public Discipline(String name) {
		this();
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

	public Set getUserLikes(){
		return this.userLiked;
	}

	public int getNumLikes(){
		return this.userLiked.size();
	}

	@Override
	public String toString() {
		return this.id + " - " + this.name;
	}


	//Métodos de like

	public boolean liked(String email){
		return this.userLiked.add(email);

	}

	public boolean liked(Usuario usuario){
		return this.userLiked.add(usuario.getEmail());
	}


	public boolean unliked(String email) {
		return this.userLiked.remove(email);
	}
}