package com.userManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userManagementSystem.model.User;

public interface AdminService{

	public void userRegistration(User user);
	public List<User> getAllUser();
	
}
