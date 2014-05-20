package com.anucana.web.controllers;

import org.hibernate.validator.constraints.NotEmpty;

public class UserLogin {

	@NotEmpty(groups = {UserRegistration.class})
	private String firstName;
	
	@NotEmpty(groups = {UserRegistration.class})
	private String lastName;
	
	@NotEmpty(groups = {UserRegistration.class,UserAuthentication.class,ForgotPassword.class})
	private String username;
	
	@NotEmpty(groups = {UserRegistration.class,UserAuthentication.class})
	private String password;
	
	@NotEmpty(groups = {UserRegistration.class})
	private String passwordRepeat;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	
	public interface UserRegistration{
	}
	
	public interface UserAuthentication{
		
	}
	public interface ForgotPassword{
		
	}
	
}
