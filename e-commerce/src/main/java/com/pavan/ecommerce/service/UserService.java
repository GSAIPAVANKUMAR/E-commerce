package com.pavan.ecommerce.service;

import com.pavan.ecommerce.entity.User;
import com.pavan.ecommerce.web.dto.UserRegistrationDto;

public interface UserService {
	User register(User user);

	User findByEmail(String email);
}
