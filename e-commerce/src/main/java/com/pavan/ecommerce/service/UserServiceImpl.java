package com.pavan.ecommerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.ecommerce.entity.RoleEnum;
import com.pavan.ecommerce.entity.User;
import com.pavan.ecommerce.exceptions.EmailPasswordException;
import com.pavan.ecommerce.exceptions.UserAlreadyExistsException;
import com.pavan.ecommerce.repository.UserRepository;
import com.pavan.ecommerce.web.dto.GetUsersDto;
import com.pavan.ecommerce.web.dto.LoginDto;
import com.pavan.ecommerce.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User register(User user) throws UserAlreadyExistsException {
		User savedUser;
		try {
			User existingUser = userRepository.findByEmail(user.getEmail());
			System.out.println("User: "+user.getRole());
			savedUser = userRepository.save(user);
		} catch (Exception e) {
			throw new UserAlreadyExistsException("User with email already exists");
		}
		return savedUser;
	}

	@Override
	public User login(LoginDto loginDto) {

		try {
			System.out.println("inside try - catch block " + loginDto.getEmail());
			User existingUser = userRepository.findByEmail(loginDto.getEmail());
			System.out.println("Existing user: " + existingUser);
			if (existingUser.getPassword().equals(loginDto.getPassword())) {
				System.out.println("Password matched: " + existingUser);
				return existingUser;
			} else {
				System.out.println("Password not matched: " + existingUser);
				throw new EmailPasswordException("Email or password is incorrect");
			}

		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public ArrayList<User> getUsers(GetUsersDto getUsersDto) {
		ArrayList<User> users = new ArrayList<User>();
		System.out.println("role: " + getUsersDto.getRole());
		users = userRepository.findByRole(getUsersDto.getRole());
		System.out.println("Users in service impl: " + users);
		return users;
	}

}
