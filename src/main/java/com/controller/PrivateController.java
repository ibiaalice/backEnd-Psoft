package com.controller;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@RestController
public class PrivateController {

	@GetMapping("/private")
	public String privateMsg() {
		return "user logged!";
	}

	@GetMapping("/public")
	public String publicMsg() {
		return "user not logged!";
	}


}