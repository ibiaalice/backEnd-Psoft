package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import service.UserService;

@RestController
@RequestMapping({ "/v1/users" }) // ver com Gabriel essa notação de bd
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<User> findById(@PathVariable String email) {
		if (userService.containsUser(email) == false)
			System.out.println("Vou fazer aqui ainda alguma coisa");
		// throw new UserNotExistException("This user does not exist!");

		User user = (User) userService.findByEmail(email);// findByCodeUser ainda com retorno Object :(

		return new ResponseEntity<User>(user, HttpStatus.OK);

	}

	@PostMapping(value = "/")
	@ResponseBody
	public ResponseEntity<User> create(@RequestBody User user) {
		if (userService.containsUser(user.getEmail()))
			System.out.println("pipipi popopo!");
		// throw new UserExistException("This user already exist!");
		User newUser = userService.create(user);

		return new ResponseEntity<User>(newUser, HttpStatus.CREATED);

	}
	
	

}
