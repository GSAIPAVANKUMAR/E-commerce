package com.pavan.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pavan.ecommerce.entity.RoleEnum;
import com.pavan.ecommerce.entity.User;
import com.pavan.ecommerce.exceptions.UserAlreadyExistsException;
import com.pavan.ecommerce.repository.UserRepository;
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

			savedUser = userRepository.save(user);
		} catch (Exception e) {
			throw new UserAlreadyExistsException("User with email already exists");
		}
		return savedUser;

	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
