package com.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import exception.AuthException;
import exception.UserNotExistException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.model.Usuario;
import com.model.UserDTO;
import com.service.UserService;

/**
 * Classe de Controle De login
 */
@RestController
@RequestMapping("/v1/auth")
public class LoginController {
	private final String TOKEN_KEY = "biscoitocomtoddy";

	@Autowired
	private UserService userService;

	/**
	 * Método de login do sistema
	 * @param user recebe o Usuario para login
	 * @return retorna uma entidade com cópias do User, com um token
	 * @throws AuthException um erro de login
	 */
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<UserDTO> authenticate(@RequestBody Usuario user) throws AuthException {
		Usuario authUser = (Usuario) userService.findByEmail(user.getEmail());

		if(authUser == null) throw new AuthException("User not found!");

		String passwd = authUser.getPasswd();

		if(!authUser.getPasswd().equals(passwd)) throw new AuthException("Wrong Password!");

		final String token = Jwts.builder().setSubject(authUser.getPasswd()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY).
				setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();

		UserDTO userDTO = new UserDTO(authUser.getFirstName(), authUser.getLastName(), authUser.getEmail(),token);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.FOUND);


	}

}