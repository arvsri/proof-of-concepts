package com.anucana.web.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controls the user login ( authentication and authorization )  
 * 
 * @author asrivastava
 * 
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/home")
	public String homePage(ModelMap model){
		printSecurityDetails("home");
		return "home";
	}

	@RequestMapping(value = "/managed/dashboard")
	public String dashboard(){
		printSecurityDetails("dashboard");
		return "dashboard";
	}

	@RequestMapping(value = "/managed/changepassword")
	public String changepassword(){
		printSecurityDetails("changepassword");
		return "changepassword";
	}

	@RequestMapping(value = "/managed/createAnEvent")
	public String createAnEvent(){
		printSecurityDetails("createAnEvent");
		return "createAnEvent";
	}

	@RequestMapping(value = "/managed/suspendOtherUser")
	public String suspendOtherUser(){
		printSecurityDetails("suspendOtherUser");
		return "suspendOtherUser";
	}
	
	private void printSecurityDetails(String callerName){
		System.out.println("------------------------------ " + callerName + " ---------------------- ");
		if(SecurityContextHolder.getContext() != null){
			if(SecurityContextHolder.getContext().getAuthentication() != null){
				System.out.println( "Credentials = " + SecurityContextHolder.getContext().getAuthentication().getCredentials());
				System.out.println( "Details = " + SecurityContextHolder.getContext().getAuthentication().getDetails());
				System.out.println( "Name = " + SecurityContextHolder.getContext().getAuthentication().getName());
				System.out.println( "Principal = " + SecurityContextHolder.getContext().getAuthentication().getPrincipal());
				System.out.println( "Authorities = " + SecurityContextHolder.getContext().getAuthentication().getAuthorities());
			}else{
				System.out.println("Authentication Object is null");
			}
		}else{
			System.out.println("Not security context available");
		}
		System.out.println("------------------------------ " + callerName + " ---------------------- ");
	}
	
}



