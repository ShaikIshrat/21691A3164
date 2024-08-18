package com.ecommerce.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.api.model.User;
import com.ecommerce.api.model.UserResponse;
import com.ecommerce.api.service.UserService;

@RestController
@RequestMapping("/test")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<UserResponse> registerUser(@RequestBody User user){
		return service.registerUser(user);
	}
}
