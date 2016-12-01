package levelup.world.web;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	public String login(){
		return "login";
	}
	
	public String login(String userName, String password)
	{
		return "team";
	}
	
	/*public String signup(){
		return "signup";
	}
	
	public String signup()
	{
		System.out.println(user.getCountry());
		return "login";
	}*/
}
