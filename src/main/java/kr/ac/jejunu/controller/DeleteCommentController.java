package kr.ac.jejunu.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.exception.LoginRequiredException;
import kr.ac.jejunu.exception.OwnerNotMatchedException;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeleteCommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/comment/{commentId}/delete")
	@ResponseBody
	public String deleteComment(@PathVariable int commentId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			try {
				commentService.deleteComment(user.getId(), commentId);
			} catch (OwnerNotMatchedException e) {
				return "{\"result\":\"onwer not match\"}";
			}
			return "{\"result\":\"success\"}";
		}
		throw new LoginRequiredException();
	}
}
