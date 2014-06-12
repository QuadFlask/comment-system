package kr.ac.jejunu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/")
	public ModelAndView commentList(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("commentList", commentService.getCommentList(1));
		mv.addObject("user", session.getAttribute("user"));
		return mv;
	}
}
