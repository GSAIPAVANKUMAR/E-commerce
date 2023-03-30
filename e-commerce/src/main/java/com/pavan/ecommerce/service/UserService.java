package com.pavan.ecommerce.service;

import java.util.ArrayList;

import com.pavan.ecommerce.entity.User;
import com.pavan.ecommerce.web.dto.GetUsersDto;
import com.pavan.ecommerce.web.dto.LoginDto;
import com.pavan.ecommerce.web.dto.UserRegistrationDto;

public interface UserService {
	User register(User user);

	User findByEmail(String email);

	User login(LoginDto loginDto);

	ArrayList<User> getUsers(GetUsersDto getUsersDto);
}
