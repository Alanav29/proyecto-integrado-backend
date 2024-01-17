package org.generation.app.controller;

import org.generation.app.entity.User;
import org.generation.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@PostMapping
	User setUser(@RequestBody User user) {	
		User validatedUser = userService.validateUser(user);
		return validatedUser;
	}
}
