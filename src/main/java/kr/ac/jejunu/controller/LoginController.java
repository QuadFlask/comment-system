package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/loginAction", method = RequestMethod.POST)
	public String loginAction(User user) {
		if (userService.login(user))
			return "redirect:/write";
		return "redirect:/login";
	}

}
