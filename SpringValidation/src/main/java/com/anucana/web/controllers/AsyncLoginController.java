package com.anucana.web.controllers;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anucana.web.controllers.UserLogin.UserRegistration;

@Controller
@RequestMapping(value =  "/user/**")
public class AsyncLoginController {

	@Autowired
	private Validator validator;
	
	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public ModelAndView user(){
		ModelAndView mv = new ModelAndView("AsyncUserForm");
		mv.addObject(new UserLogin());
		return mv;
	}
	
	@RequestMapping(value = {"create"}, method = RequestMethod.POST)
	 public ModelAndView create(UserLogin userlogin,HttpServletRequest request){
		request.getParameterNames();
		ModelAndView mv = new ModelAndView("AsyncUserForm");
		ServiceResponse<UserLogin> res = validate(new ServiceRequest<UserLogin>(userlogin,"userlogin"),UserRegistration.class);
		if(res.getBindingResult().hasFieldErrors()){
			mv.addObject("org.springframework.validation.BindingResult.userLogin",res.getBindingResult());
		}
		return mv;	
	}
	private ServiceResponse<UserLogin> validate(ServiceRequest<UserLogin> req,Object ... validationHints){
		req.setValidator(validator);
		req.validate(validationHints);
		System.out.println(ToStringBuilder.reflectionToString(req.getTarget()));
		if(req.getBindingResult().hasErrors()){
			System.out.println("Errors exists ");
			return req;
		}
		
		return new ServiceResponse<UserLogin>((UserLogin)req.getObject(),"userlogin");
		
	}
	
}


