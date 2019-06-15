package service;

import java.io.IOException;

import org.hibernate.Filter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.filter.GenericFilterBean;

import exception.AuthException;


public class TokenFilter //GenericFilterBean {
	

	public void doFilter(ServerHttpRequest request, ServerHttpResponse response, Filter chain)
			throws IOException, AuthException {
			
			ServerHttpRequest req = (ServerHttpRequest) request;
			
			String header = null;
					//req.getHeader("Authorization");
			
			if(header == null || !header.startsWith("Bearer ")) {
				throw new ServletException("Token inexistente ou mal formatado!"); //não existe essa porcaria!
			}

		System.out.println("sjdjgjgajg");
	}
	
}
