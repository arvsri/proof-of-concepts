package com.anucana.web.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thoughtworks.xstream.XStream;

/**
 * Controls the user login ( authentication and authorization )  
 * 
 * @author asrivastava
 * 
 */
@Controller
@RequestMapping
public class LoginController {

	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public ModelAndView showLogin(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = {"forumLogin"}, method = RequestMethod.POST)
	public ModelAndView forumLogin(@RequestParam(required = false) String username){
		
		StringBuilder errorMsg = new StringBuilder("An error occured while logging into discussion forum !");
		try {
			if(!StringUtils.isEmpty(username)){
				XStream xstream = new XStream();
				xstream.alias("response", Response.class);
				Response response = (Response) xstream
						.fromXML(readHTML(new URL("http://disqus.websitetoolbox.com/register/setauthtoken?apikey=XXXXXXX&user="+ getEscapedString(username))));
				
				System.out.println("Response Auth Token: " + response.getAuthtoken());
				System.out.println("Response Error Message: " + response.getErrormessage());

				if(!StringUtils.isEmpty(response.getAuthtoken())){
					ModelAndView mv = new ModelAndView("forumRedirect");
					mv.addObject(response);
					return mv;
				}else{
					errorMsg.append(" Reason : ").append(response.getErrormessage());
				}
				
			}else{
				errorMsg.append(" Reason : ").append("User name not found");
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			errorMsg.append(" Reason : ").append(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			errorMsg.append(" Reason : ").append(e.getMessage());
		}
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("loginErrorMessage",errorMsg.toString());
		return mv;
	}
	
	@RequestMapping(value = {"forumRegister"}, method = RequestMethod.POST)
	public ModelAndView forumRegister(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String username,
			@RequestParam(required = false) String password,
			@RequestParam(required = false) String email) {

		StringBuilder errorMsg = new StringBuilder("An error occured while registering into discussion forum !");
		
		if(!StringUtils.isEmpty(name) && !StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(email)){
			try {
				XStream xstream = new XStream();
				xstream.alias("response", Response.class);
				xstream.alias("data_response", DataResponse.class);
				
				Response response = (Response)xstream.fromXML(readHTML(new URL("http://disqus.websitetoolbox.com/register/setauthtoken?apikey=XXXXXXXX&user=" + getEscapedString(username))));
				if(!StringUtils.isEmpty(response.getAuthtoken())){
					ModelAndView mv = new ModelAndView("forumRedirect");
					mv.addObject(response);
					return mv;
				}else{
					System.out.println("Error Message :" + response.getErrormessage());

					DataResponse dataResponse = (DataResponse) xstream
							.fromXML(readHTML(new URL(
									"http://disqus.websitetoolbox.com/register/create_account?apikey=XXXXXX"
									+ "&member=" + getEscapedString(username)
									+ "&pw=" + password
									+ "&email=" + email
									+ "&name=" + getEscapedString(name))));
					System.out.println("Registration Error : " + dataResponse.getError());
					System.out.println("Registration Message : " + dataResponse.getMessage());
					System.out.println("Registration User Id : "+ dataResponse.getUserid());
					
					return forumLogin(username);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
				errorMsg.append(" Reason : ").append(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				errorMsg.append(" Reason : ").append(e.getMessage());
			}
		}else{
			errorMsg.append(" Reason : ").append("Invalid Details Entered");
		}
		
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("registrationErrorMessage",errorMsg.toString());
		return mv;
	}	
	
	private InputStream readHTML(URL url) throws IOException{
		URLConnection yc = url.openConnection();
		yc.setConnectTimeout(10000);
		return yc.getInputStream();
	}

	private String getEscapedString(String str) throws UnsupportedEncodingException{
		String esacpedURL = URLEncoder.encode(str, "utf-8").replaceAll("\\+", "%20"); 
		System.out.println(esacpedURL);
		return esacpedURL;
	}


}
