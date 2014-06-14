package kr.ac.jejunu.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.exception.DuplicatedRequestException;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeleteCommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/comment/{commentId}/delete")
	public String deleteComment(@PathVariable int commentId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			try {
				commentService.deleteComment(user.getId(), commentId);
			} catch (DuplicatedRequestException e) {
				return "{\"result\":\"duplicated\"}";
			}
			return "{\"result\":\"success\"}";
		}
		throw new RuntimeException();
	}
}
