package service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import model.User;
import dao.UserDAO;

@Service 
public class UserService {
	private final UserDAO userDAO;

	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User create(User user) {
		if(containsUser(user)) 
			System.out.println("ainda vou fazer algo aqui");
			//throw new UserExistException("there is a registered user with the same data.");
		
		return userDAO.save(user);
	}
	
	public void delete(Long codeUser) {
		userDAO.deleteById(codeUser);
	}
	
	/**
	 * Espero tirar a duvida do pq não retorna um User
	 * @param email
	 * @return deveria retornar um User
	 */
	public Object findByEmail(String email) {
		return userDAO.findById(email);
	}
	
	private boolean containsUser(User user) {
		return userDAO.existsById(user.getEmail());
	}
	
	public boolean containsUser(String email) {
		return userDAO.existsById(email);
	}
	
}
