package com.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.AuthException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {
	private final String TOKEN_KEY = "biscoitocomtoddy";
	
	@Autowired
	private UserService userService;
	
	
	public LoginResponse authenticate(@RequestBody User user) throws AuthException {		
		User authUser = (User) userService.findByEmail(user.getEmail());
		
		if(authUser == null) throw new AuthException("User not found!");
		
		if(!authUser.getPasswd().equals(user.getPasswd())) throw new AuthException("Wrong Password!");
		
		final String token = Jwts.builder().setSubject(authUser.getPasswd()).signWith(SignatureAlgorithm.HS512, TOKEN_KEY).
				setExpiration(new Date(System.currentTimeMillis() + 1 * 60 * 1000))
				.compact();

		
		return new LoginResponse(token);
	}

}

/**
 * Objeto de retorno com o token... 
 * (não gosto da sua existência :( ) 
 * @author biaalice
 *
 */
class LoginResponse {
	public String token;
	
	public LoginResponse(String token) {
		this.token = token;
	}
}
