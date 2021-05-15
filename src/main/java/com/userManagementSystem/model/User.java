package com.userManagementSystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;



@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty(message = "Please enter the userName")
	@Column(unique=true, nullable=false)
	private String userName;
	@NotEmpty(message = "Please enter the password")
	@Size(max = 18, min = 6, message = "Please enter the valid password}")
	private String password;
	@NotEmpty(message = "first name must not be empty")
	private String firstName;
	@NotEmpty(message = "last name must not be empty")
	private String lastName;
	@Temporal(TemporalType.DATE)
	private Date dob;
	private String roles;
	private  boolean active;
	
	public User() {}
	
	public User(@NotEmpty(message = "Please enter the userName") String userName,
			@NotEmpty(message = "Please enter the password") @Size(max = 18, min = 6, message = "Please enter the valid password}") String password,
			@NotEmpty(message = "first name must not be empty") String firstName,
			@NotEmpty(message = "last name must not be empty") String lastName, Date dob, String roles,
			boolean active) {
		super();
		
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.roles = roles;
		this.active = active;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
