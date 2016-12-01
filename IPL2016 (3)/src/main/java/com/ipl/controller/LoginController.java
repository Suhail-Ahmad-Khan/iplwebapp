package com.ipl.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipl.dao.UserDao;
import com.ipl.model.User;
import com.ipl.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	
	 @RequestMapping("/loginPage")
	 public String init() {
	        /*model.addAttribute("msg", "Please Enter Your Login Details");*/
	        return "login";
	    }
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	  public String login(@RequestParam("Email") String email,@RequestParam("Password") String password ) {
		 User user = userService.authUser(email, password);
		 // authenticate session
		 
		 if (user == null) 
		 {
	          return "login";
	     }
		 else 
		 {
	        return "success";
	     }

	  }
}
