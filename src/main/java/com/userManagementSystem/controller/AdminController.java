package com.userManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userManagementSystem.exception.UserNotFound;
import com.userManagementSystem.model.User;
import com.userManagementSystem.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@PostMapping("/adduser")
	public ResponseEntity addUser (@Valid @RequestBody User user) throws Exception {
		adminService.userRegistration(user);
		logger.info("new user added");
		return  new ResponseEntity("user added successfully",HttpStatus.OK);
		
	}

	
	  @GetMapping("/getalluser") public ResponseEntity<List<User>>
	  getAllUserDetails() throws Exception {
	  
	  return new ResponseEntity(adminService.getAllUser(), HttpStatus.OK);
	  
	  }
	  
	 

}
