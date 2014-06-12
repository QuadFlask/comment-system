package kr.ac.jejunu.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/java/test-context.xml")
public class CommentServiceTest {

	@Autowired
	CommentService commentService;

	@Test
	public void getCommentList() {
		List<Comment> comments = commentService.getCommentList(1);
		assertTrue(comments.size() == 1);

		Comment comment = comments.get(0);
		assertThat(comment.getCommentId(), is(1));
		assertThat(comment.getWriter().getId(), is("pop2331"));
		assertThat(comment.getWriter().getName(), is("성의현"));
		assertThat(comment.getContents(), is("test"));
	}

	@Test
	@Transactional
	public void writeComment() {
		Comment comment = new Comment();
		User writer = new User("pop2331", "flask", null, null);
		comment.setWriter(writer);
		comment.setContents("test comment text");
		commentService.write(comment);

		List<Comment> commentList = commentService.getCommentList(1);
		assertTrue(commentList.size() == 2);
	}
}
