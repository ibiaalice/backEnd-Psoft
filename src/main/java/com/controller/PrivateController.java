package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe de metodos de login
 */
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