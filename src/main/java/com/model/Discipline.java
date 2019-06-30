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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //gera o valor do id
	private long id;
	@Column(name = "name")
	private String name;

	//@Column(name = "likes")
	@ElementCollection(targetClass=String.class)
	private Set<String> userLiked;

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
	 * método de retorno da coleção de "likes" da Discipline
	 * @return retorna uma coleção com emails de quem curtiu
	 */
	public Set getUserLikes(){
		return this.userLiked;
	}

	/**
	 * Método de retorno da quantidade de "likes" da Discipline
	 * @return retorna um inteiro com a quantidade de likes
	 */
	public int getNumLikes(){
		return this.userLiked.size();
	}

	/**
	 * Método de modificaação do nome da Discipline
	 * @param name novo nome a ser recebido.
	 */
	public void setName(String name) {
		this.name = name;
	}


	//Métodos de like

	/**
	 * Método de adição de Likes na Discipline
	 * @param email email a ser adicionado na coleção
	 * @return retorna um valor em booleano, se foi adicionado a curtida True, caso contrário False
	 */
	public boolean liked(String email){
		return this.userLiked.add(email);

	}

	/**
	 * Método de adição de Likes na Discipline
	 * @param usuario recebe o usuário que deu Like
	 * @return retorna um valor booleano, se foi adicionada a curtida True, caso contrário False
	 */
	public boolean liked(Usuario usuario){
		return this.userLiked.add(usuario.getEmail());
	}

	/**
	 * Método de remoção de likes na Discipline
	 * @param email recebe o email do usuário que quer retirar like
	 * @return retorna um valor booleano, se foi retirada a curtida True, caso contrário False
	 */
	public boolean unliked(String email) {
		return this.userLiked.remove(email);
	}


	@Override
	public String toString() {
		return this.id + " - " + this.name;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return super.equals(o);
	}
}