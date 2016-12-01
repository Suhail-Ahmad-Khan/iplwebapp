package org.bridgelabz.iplwebapp.controller;

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

	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.authUser(email, password);
		// authenticate session

		if (user == null) {
			return "login";
		} else {
			return "teamList";
		}

	}

}