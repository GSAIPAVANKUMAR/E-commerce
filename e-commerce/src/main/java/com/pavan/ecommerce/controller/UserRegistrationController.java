package com.pavan.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.ecommerce.entity.StatusEnum;
import com.pavan.ecommerce.entity.User;
import com.pavan.ecommerce.exceptions.UserAlreadyExistsException;
import com.pavan.ecommerce.service.UserService;
import com.pavan.ecommerce.web.dto.LoginDto;
import com.pavan.ecommerce.web.dto.Responsedto;

@RestController
@RequestMapping("/api/users")
public class UserRegistrationController {
	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Responsedto> register(@RequestBody User user) {

		User savedUser = null;
		Responsedto responseDto = new Responsedto(StatusEnum.RS_OK, "Registration successfull");
		try {
			savedUser = userService.register(user);
			System.out.println("Exception : " + savedUser);
		} catch (UserAlreadyExistsException e) {
			responseDto.setStatus(StatusEnum.RS_ERROR);
			responseDto.setErrorDescription("Registration unsuccessfull - Email already used.");
			return ResponseEntity.ok(responseDto);
		}
		return ResponseEntity.ok(responseDto);
	}

//	@PostMapping("/login")
//	public ResponseEntity<Responsedto> login(@RequestBody LoginDto loginDto) {
//		
//	}
}
