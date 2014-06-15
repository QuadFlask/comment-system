package kr.ac.jejunu.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentListController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/")
	public ModelAndView commentList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			HttpSession session) {
		page = Math.max(page, 1);
		User user = (User) session.getAttribute("user");
		if (user != null)
			user.setPassword(null);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("commentList", commentService.getCommentList(page));
		mv.addObject("user", user);
		mv.addObject("currentPage", page);
		mv.addObject("totalPageCount", commentService.getTotalPageCount());
		
		return mv;
	}
}
