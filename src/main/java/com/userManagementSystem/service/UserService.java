package com.userManagementSystem.service;

import java.util.Optional;

import com.userManagementSystem.model.User;

public interface UserService {
	public String changeUserPassword(String userName,String oldPassword,String newPassword);
	public User editUserDetails(User user,String userName);
	public Optional<User> getUserDetails(String userName);
	
}
