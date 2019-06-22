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
import com.model.User;
import com.model.UserDTO;
import com.service.UserService;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {
	private final String TOKEN_KEY = "biscoitocomtoddy";
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<UserDTO> authenticate(@RequestBody String email) throws AuthException {		
		User authUser = (User) userService.findByEmail(email);
		
		if(authUser == null) throw new AuthException("User not found!");
		
		if(!authUser.getPasswd().equals(email)) throw new AuthException("Wrong Password!");
		
		final String token = Jwts.builder().setSubject(authUser.getPasswd()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY).
				setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();

		UserDTO userDTO = new UserDTO(authUser.getFirstName(), authUser.getLastName(), authUser.getEmail(),token);
		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.FOUND);
		
		
	}

}

