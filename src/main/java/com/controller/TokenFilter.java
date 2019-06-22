package com.controller;

import org.springframework.web.filter.GenericFilterBean;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import com.service.UserService;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;


public class TokenFilter extends GenericFilterBean  {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Authorization");
		
		if(header == null || !header.startsWith("Bearer ")) {
			throw new ServletException("Token no exist!");
		}
		
		String token = header.substring(7);
		
		try {
			Jwts.parser().setSigningKey("biscoitocomtoddy").parseClaimsJws(token).getBody();
			
		}catch(SignatureException e) {
			throw new ServletException("Token is invalid!");
		}
		
		chain.doFilter(request, response);
	}

}
