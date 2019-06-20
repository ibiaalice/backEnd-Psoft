package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exception.UserExistException;
import exception.UserNotExistException;
import com.model.User;
import com.model.UserDTO;
import com.service.UserService;

@RestController
@RequestMapping({ "/v1/users" }) 
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{email}")
	@ResponseBody
	public ResponseEntity<User> findByEmail(@PathVariable String email) {
		if (userService.containsUser(email) == false)
			throw new UserNotExistException("This user does not exist!");

		User user = (User) userService.findByEmail(email);// findByCodeUser ainda com retorno Object :(

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<UserDTO> login(@RequestBody String email){
		User newUser = (User) userService.findByEmail(email);
		
		if(!userService.containsUser(email)) {
			throw new UserNotExistException("Usuário inexistente");
		}
		UserDTO userDTO = new UserDTO(newUser.getFirstName(), newUser.getLastName(), newUser.getEmail(), "istoeutoken");
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.FOUND);
	}

	@PostMapping(value = "/signup")
	@ResponseBody
	public ResponseEntity<UserDTO> create(@RequestBody User user) {
		if (userService.containsUser(user.getEmail())) {
			throw new UserExistException("This user already exist!");
		}
		User newUser = userService.create(user);
		UserDTO userDTO = new UserDTO(newUser.getFirstName(),newUser.getLastName(),newUser.getEmail(), "useaimaginacao");

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);

	}
	
	
}
