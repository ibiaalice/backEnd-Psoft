package com.controller;

import java.sql.Date;

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
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.model.UserDTO;
import com.model.Usuario;
import com.service.UserService;

@RestController
@RequestMapping({ "/v1/users" })
public class UserController {
	private UserService userService;
	private final String TOKEN_KEY = "biscoitocomtoddy"; //para o token do objeto criado 

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{email}")
	@ResponseBody
	public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
		if (userService.containsUser(email) == false)
			throw new UserNotExistException("This user does not exist!");

		Usuario user = (Usuario) userService.findByEmail(email);// findByCodeUser ainda com retorno Object :(

		return new ResponseEntity<Usuario>(user, HttpStatus.OK);

	}

	@PostMapping(value = "/signup")
	@ResponseBody
	public ResponseEntity<UserDTO> create(@RequestBody Usuario user) {
		if (userService.containsUser(user.getEmail())) {
			throw new UserExistException("This user already exist!");
		}
		Usuario newUser = userService.create(user);

		final String token = Jwts.builder().setSubject(user.getPasswd()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY).
				setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();

		UserDTO userDTO = new UserDTO(newUser.getFirstName(),newUser.getLastName(),newUser.getEmail(), token);

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.CREATED);

	}


}