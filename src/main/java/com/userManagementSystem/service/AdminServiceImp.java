package com.userManagementSystem.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.userManagementSystem.model.User;
import com.userManagementSystem.repository.UserRepo;

@Service("AdminService")
@Transactional
public class AdminServiceImp implements AdminService{
	Logger logger=LoggerFactory.getLogger(AdminServiceImp.class);
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public void userRegistration(User user) {
		try {
			userRepo.save(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
		
	}

	
	@PostConstruct
	private void postConstruct() {
		User user=new User("admin1","admin@","rahul","ranjan", null, "admin",true);
		userRepo.save(user);
		logger.info("......Please find admin details which is inserted default userName =  admin1 and password= admin@ and role=admin......use this credencial to add more user ");
	}

}
