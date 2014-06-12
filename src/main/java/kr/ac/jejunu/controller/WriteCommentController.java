package kr.ac.jejunu.controller;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteCommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/writeAction")
	public String writeAction(Comment comment) {
		commentService.write(comment);
	}
}
