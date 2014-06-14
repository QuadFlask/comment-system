package kr.ac.jejunu.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.exception.DuplicatedRequestException;
import kr.ac.jejunu.exception.LoginRequiredException;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OppositeCommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("comment/{commentId}/opposite")
	@ResponseBody
	public String incOppositeAction(@PathVariable int commentId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user != null) {
			try {
				commentService.oppositeComment(user.getId(), commentId);
			} catch (DuplicatedRequestException e) {
				return "{\"result\":\"duplicated\"}";
			}
			return "{\"result\":\"success\"}";
		}
		throw new LoginRequiredException();
	}
}
