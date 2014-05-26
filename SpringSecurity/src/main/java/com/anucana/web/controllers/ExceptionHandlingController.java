package com.anucana.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controls the exception handling  
 * 
 * @author asrivastava
 * 
 */
@Controller
public class ExceptionHandlingController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
 		ModelAndView model = new ModelAndView("genericError");
		return model;
	}
}
