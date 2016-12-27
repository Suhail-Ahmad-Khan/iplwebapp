package org.bridgelabz.iplwebapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.bridgelabz.iplwebapp.model.User;
import org.bridgelabz.iplwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping("/loginPage")
	public String init() {
		/* model.addAttribute("msg", "Please Enter Your Login Details"); */
		return "login";
	}

	@RequestMapping(value = "/loginpage", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletRequest request) {
		User user = userService.authUser(email, password);
		// authenticate session

		if (user == null) {
			return "login";
		} else {
			HttpSession sesion = request.getSession();
			sesion.invalidate(); // invalidate existing session
			
			sesion = request.getSession();
			sesion.setAttribute("user", user);
			sesion.setMaxInactiveInterval(15);
			
			
			return "success";
		}
		
		
	}
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		sesion = request.getSession();
		return "index";

	}
}
