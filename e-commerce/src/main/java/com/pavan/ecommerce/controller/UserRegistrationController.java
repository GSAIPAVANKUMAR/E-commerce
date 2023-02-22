package com.pavan.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.ecommerce.entity.User;
import com.pavan.ecommerce.exceptions.UserAlreadyExistsException;
import com.pavan.ecommerce.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {

		User savedUser = null;
		try {
			savedUser = userService.register(user);
			System.out.println("Exception : " + savedUser);
		} catch (UserAlreadyExistsException e) {

		}
		
		return ResponseEntity.ok(savedUser);
	}
}
