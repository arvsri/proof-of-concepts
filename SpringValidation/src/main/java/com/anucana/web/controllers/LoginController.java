package com.anucana.web.controllers;

import javax.validation.Valid;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anucana.web.controllers.UserLogin.ForgotPassword;
import com.anucana.web.controllers.UserLogin.UserAuthentication;
import com.anucana.web.controllers.UserLogin.UserRegistration;

/**
 * Controls the user login ( authentication and authorization )  
 * 
 * @author asrivastava
 * 
 */
@Controller
@RequestMapping
public class LoginController {

	@Autowired
	private Validator validator;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public ModelAndView create(@RequestParam("ops") String ops){
		ModelAndView mv = new ModelAndView("UserForm");
		mv.addObject("ops", ops);
		mv.addObject(new UserLogin());
		return mv;
	}

	//@RequestMapping(value = {"/saveForm"}, method = RequestMethod.POST)
	public String saveForm(@Valid UserLogin userlogin,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "UserForm";
		}
		return "Success";
	}
	
	
	@RequestMapping(value = {"/operate"}, method = RequestMethod.POST)
	public ModelAndView operate(UserLogin userlogin,@RequestParam("ops") String ops){
		Object[] validationGroups = null;
		if("create".equalsIgnoreCase(ops)){
			validationGroups = new Class[]{UserRegistration.class};
		}else if("login".equalsIgnoreCase(ops)){
			validationGroups = new Class[]{UserAuthentication.class};
		}else if("forgotPassword".equalsIgnoreCase(ops)){
			validationGroups = new Class[]{ForgotPassword.class};
		}
		
		ServiceResponse<UserLogin> res = validate(new ServiceRequest<UserLogin>(userlogin,"userlogin"),validationGroups);
		if(res.getBindingResult().hasFieldErrors()){
			ModelAndView mv = new ModelAndView("UserForm");
			mv.addObject("ops", ops);
			mv.addObject("org.springframework.validation.BindingResult.userLogin",res.getBindingResult());
			return mv;	
		}
		return new ModelAndView("Success");
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

class ServiceResponse<T> extends DataBinder{
	public ServiceResponse(T target) {
		super(target);
	}

	public ServiceResponse(T target,String targetName) {
		super(target,targetName);
	}
	
	@SuppressWarnings("unchecked")
	public T getObject(){
		return (T)getTarget();
	}
	
}

class ServiceRequest<T> extends ServiceResponse<T>{

	public ServiceRequest(T target) {
		super(target);
	}
	
	public ServiceRequest(T target,String targetName) {
		super(target,targetName);
	}
	

}
