package com.pavan.ecommerce.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pavan.ecommerce.entity.RoleEnum;
import com.pavan.ecommerce.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

//	@Query(value = "", nativeQuery = true)
	ArrayList<User> findByRole(RoleEnum role);
}
