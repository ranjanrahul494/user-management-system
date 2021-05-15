package com.userManagementSystem.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userManagementSystem.exception.UserNotFound;
import com.userManagementSystem.model.User;
import com.userManagementSystem.service.UserService;

/*
 * perform operation by user. User can get own details and they can modify the details 
 * */

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	Logger logger=LoggerFactory.getLogger(UserController.class);

	//find user details by id
	
	@GetMapping("/userdetails/{username}")
	public ResponseEntity<Optional<User>> getUserDetails(@PathVariable("username") String username) {

			Optional<User> user=userService.getUserDetails(username);
			if(!user.isPresent()) {
				logger.error("Record not found with id :" + username);
				throw new UserNotFound(username);
			}
			logger.info("user "+ username+ " get the record");
			return new ResponseEntity(user, HttpStatus.OK);
		
	}

	//edit user profile 
	
	@PutMapping("/edituserdetails/{username}")
	public ResponseEntity<User> editUserDetails(@Valid @RequestBody User user, @PathVariable("username") String username) {
		try {
			User userdetails=userService.editUserDetails(user, username);
			logger.info("user"+ username+ "edit the details");
			return new ResponseEntity(userdetails, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			logger.error("Record not found with id :" + username);
			throw new UserNotFound("Record not found with id :" + username);
		}

	}
	
	@PutMapping("/User")
	public String changePassword (@PathVariable("username") String username,@RequestParam String oldPassword,@RequestParam String newPassword) {
		String msg=userService.changeUserPassword(username,oldPassword,newPassword);
		return msg;
	}

}
