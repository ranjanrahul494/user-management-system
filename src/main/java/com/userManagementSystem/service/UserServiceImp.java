package com.userManagementSystem.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userManagementSystem.controller.UserController;
import com.userManagementSystem.exception.UserNotFound;
import com.userManagementSystem.model.User;
import com.userManagementSystem.repository.UserRepo;

@Service("UserService")
@Transactional
public class UserServiceImp implements UserService{
	

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public String changeUserPassword(String userName,String oldPassword,String newPassword) {
		Optional<User> user=userRepo.findByUserName(userName);
		if(oldPassword.equals(user.get().getPassword())) {
			user.get().setPassword(newPassword);
			userRepo.save(user.get());
			return "password update successfully";
		}
		return "please enter correct password";
		
	}

	@Override
	public User editUserDetails(User user,String userName) {
		Optional<User> userdetails=userRepo.findByUserName(userName);
		if(userdetails.isPresent()) {
			User userUpdate=userdetails.get();
			userUpdate.setFirstName(user.getFirstName());
			userUpdate.setLastName(user.getLastName());
			userUpdate.setDob(user.getDob());
			return userRepo.save(user);
		}else {
			throw new UserNotFound("Record not found with userName : " + user.getUserName());
		}
		
	}

	@Override
	public Optional<User> getUserDetails(String userName) {
		// TODO Auto-generated method stub
		System.out.println(".........getUserDetails........");
		return userRepo.findByUserName(userName);
	}
	
	
	
}
