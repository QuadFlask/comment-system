package kr.ac.jejunu.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.User;
import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteCommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/writeAction")
	public void writeAction(Comment comment, HttpSession session) {
		User writer = (User) session.getAttribute("user");
		comment.setWriter(writer);
		commentService.write(comment);
	}
}
