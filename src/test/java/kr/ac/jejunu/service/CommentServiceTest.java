package kr.ac.jejunu.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejunu.model.Comment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/java/test-context.xml")
public class CommentServiceTest {

	@Autowired
	CommentService commentService;

	@Test
	public void getCommentList() {
		List<Comment> comments = commentService.getCommentList(1);
		assertTrue(comments.size() == 1);
	}
}
