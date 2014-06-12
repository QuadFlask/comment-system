package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginAction")
public class LoginController {

	UserService userService;

	public String loginAction(User user) {
		if (userService.login(user))
			return "redirect:/";
		return "login";
	}

}
