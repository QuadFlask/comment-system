package kr.ac.jejunu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	public String loginAction(User user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		if (userService.login(user)) {
			session.setAttribute("user", user);
			
			String requestURI = (String) session.getAttribute("requestURI");
			if (requestURI.equals("/write"))
				return "redirect:/write";
			else if (requestURI.contains("/comment"))
				return "close";
		}
		
		return "redirect:/login";
	}

}