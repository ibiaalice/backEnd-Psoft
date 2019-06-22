package com.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.model.Usuario;

import exception.UserExistException;

import com.dao.UserDAO;

@Service 
public class UserService {
	private final UserDAO userDAO;

	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public Usuario create(Usuario user) {
		if(containsUser(user)) { 
			throw new UserExistException("there is a registered user with the same data.");
		}
		return userDAO.save(user);
	}
	
//	public void delete(Long codeUser) {
//		userDAO.deleteById(codeUser);
//	}
	
	/**
	 * Espero tirar a duvida do pq não retorna um User
	 * @param email
	 * @return User
	 */
	public Usuario findByEmail(String email) {
		return userDAO.findByEmail(email);
	}
	
	private boolean containsUser(Usuario user) {
		Usuario user1 = userDAO.findByEmail(user.getEmail());
		if(user1 == null) {
			return false;
		}
		return true;
	}
	
	public boolean containsUser(String email) {
		Usuario user2 = userDAO.findByEmail(email);
		if(user2 == null ) {
			return false;
		}
		return true;
	}
	
}
