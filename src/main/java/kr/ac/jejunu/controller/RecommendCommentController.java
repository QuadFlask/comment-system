package kr.ac.jejunu.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecommendCommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("comment/{commentId}/recommend")
	@ResponseBody
	public String incRecommendAction(@PathVariable int commentId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			commentService.recommendComment(user.getId(), commentId);
			return "{\"result\":\"success\"}";
		}
		throw new RuntimeException(); 
	}
}
