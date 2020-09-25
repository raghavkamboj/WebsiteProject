package com.quizwebsite.core.controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import com.quizwebsite.core.exceptions.AuthenticationException;
import com.quizwebsite.core.usermodel.User;
import com.quizwebsite.core.userservice.UserLoginRegistrationService;
import com.quizwebsite.core.userservice.repository.UserRepo;

@RestController
public class RegistrationLoginController {

	@Autowired
	private UserLoginRegistrationService service;
	
	@Autowired
	UserRepo repo;
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean login(@RequestBody User user) throws AuthenticationException
	{
		service = new UserLoginRegistrationService(user,repo);
		boolean result=false;
		result = service.verifyPassword(user.getUsername(),user.getPass());
		if(!result)
			throw new AuthenticationException("");
		return result;
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean register(@RequestBody User user) throws AuthenticationException
	{
		service = new UserLoginRegistrationService(user,repo);
		boolean result=false;
		
		result = service.createUser(user.getUsername(),user.getPass());
		if(!result)
			throw new AuthenticationException("");
		return result;
		
	}
	
	/*
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	*/

}