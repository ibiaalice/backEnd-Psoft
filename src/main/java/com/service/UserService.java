package com.service;

import org.springframework.stereotype.Service;
import com.model.Usuario;
import exception.UserExistException;
import com.dao.UserDAO;

/**
 * Classe de Serviço da classe Usuario
 */
@Service
public class UserService {
	private final UserDAO userDAO;


	/**
	 * Construtor da classe
	 * @param userDAO
	 */
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * Método de criação do Usuario
	 * @param user recebe o Usuario a ser salvo no Banco de Dados
	 * @return retorna uma copoa do
	 */
	public Usuario create(Usuario user) {
		if(containsUser(user)) {
			throw new UserExistException("there is a registered user with the same data.");
		}
		return userDAO.save(user);
	}

	/**
	 * Procura Usuario por email
	 * @param email recebe o email para a procura
	 * @return User retorna uma cópia do usuário
	 */
	public Usuario findByEmail(String email) {
		return userDAO.findByEmail(email);
	}

	/**
	 * Método de verificação privada se existe usuário
	 * @param user recebe o Usuario a ser pesquisado
	 * @return retorna verdadeiro se existir, caso contrário, retorna false
	 */
	private boolean containsUser(Usuario user) {
		Usuario user1 = userDAO.findByEmail(user.getEmail());
		if(user1 == null) {
			return false;
		}
		return true;
	}

	/**
	 * Método de verificação da existencia do Usuario no banco de dados
	 * @param email recebe o email (id identificador) do Usuario
	 * @return retorna verdadeiro caso exista, e false caso não.
	 */
	public boolean containsUser(String email) {
		Usuario user2 = userDAO.findByEmail(email);
		if(user2 == null ) {
			return false;
		}
		return true;
	}


}