package org.bridgelabz.iplwebapp.controller;

import org.bridgelabz.iplwebapp.model.User;
import org.bridgelabz.iplwebapp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.validation.Valid;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signupPage", method = RequestMethod.GET)
	public String signup(Model model) {
		User user = new User();
		/* model.addAttribute("user", user); */
		return "signup";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result) {

		userService.saveUser(user);
		return "login";
	}

	@RequestMapping("/loginPage")
	public String init() {
		/* model.addAttribute("msg", "Please Enter Your Login Details"); */
		return "login";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public String login(@RequestParam("Email") String email, @RequestParam("Password") String password) {
		User user = userService.authUser(email, password);
		// authenticate session

		if (user == null) {
			return "login";
		} else {
			return "success";
		}

	}

}
