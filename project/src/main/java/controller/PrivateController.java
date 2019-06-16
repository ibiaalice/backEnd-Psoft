package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
