package self.poc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value = {"/",""})
	public ModelAndView homePage(ModelMap model){
		ModelAndView mv = new ModelAndView("homePage");
		return mv;
	}
	
}
