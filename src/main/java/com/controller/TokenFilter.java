package com.controller;

import io.swagger.annotations.Api;
import org.springframework.web.filter.GenericFilterBean;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

@Api(value="Classe de geração do Token")
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
