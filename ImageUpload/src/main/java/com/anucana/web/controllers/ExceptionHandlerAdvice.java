package com.anucana.web.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView handleSizeLimitExceeded(MaxUploadSizeExceededException ex){
		ModelAndView mv = new ModelAndView("errorPage");
		mv.addObject("imageuploaderror", "Maximum upload size of " + ex.getMaxUploadSize() /1000 + " KB exceeded");
		return mv;
	}
	
}
