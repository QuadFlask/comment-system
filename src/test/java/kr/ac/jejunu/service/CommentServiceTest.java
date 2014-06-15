package kr.ac.jejunu.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejunu.exception.DuplicatedRequestException;
import kr.ac.jejunu.exception.OwnerNotMatchedException;
import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.User;

import org.junit.Before;
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
	private User writer = new User("pop2331", "flask", null, null);
	private Comment comment;

	@Before
	public void setup() {
		comment = new Comment();
		comment.setWriter(writer);
		comment.setContents("test comment text");
	}

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
		commentService.write(comment);
		List<Comment> commentList = commentService.getCommentList(1);
		assertTrue(commentList.size() == 2);
	}

	@Test
	@Transactional
	public void recommandComment() {
		commentService.write(comment);
		Comment writtenComment = commentService.getCommentList(1).get(0);
		commentService.recommendComment(writer.getId(), writtenComment.getCommentId());

		Comment recommendedComment = commentService.getCommentList(1).get(0);
		assertThat(recommendedComment.getRecommendationCount(), is(1));
	}

	@Test
	@Transactional
	public void oppositeComment() {
		commentService.write(comment);
		Comment writtenComment = commentService.getCommentList(1).get(0);
		commentService.oppositeComment(writer.getId(), writtenComment.getCommentId());

		Comment oppositedComment = commentService.getCommentList(1).get(0);
		assertThat(oppositedComment.getOppositionCount(), is(1));
	}

	@Test(expected = DuplicatedRequestException.class)
	@Transactional
	public void recommandCommentTwiceBySameUser() {
		commentService.write(comment);
		Comment writtenComment = commentService.getCommentList(1).get(0);
		// twice!
		commentService.recommendComment(writer.getId(), writtenComment.getCommentId());
		commentService.recommendComment(writer.getId(), writtenComment.getCommentId());

		Comment recommendedComment = commentService.getCommentList(1).get(0);
		// but inc only one time
		assertThat(recommendedComment.getRecommendationCount(), is(1));
	}

	@Test(expected = DuplicatedRequestException.class)
	@Transactional
	public void oppositeCommentTwiceBySameUser() {
		commentService.write(comment);
		Comment writtenComment = commentService.getCommentList(1).get(0);
		// twice!
		commentService.oppositeComment(writer.getId(), writtenComment.getCommentId());
		commentService.oppositeComment(writer.getId(), writtenComment.getCommentId());

		Comment oppositedComment = commentService.getCommentList(1).get(0);
		// but inc only one time
		assertThat(oppositedComment.getOppositionCount(), is(1));
	}

	@Test
	@Transactional
	public void deleteComment() {
		commentService.write(comment);
		assertThat(commentService.getCommentList(1).size(), is(2));

		Comment writtenComment = commentService.getCommentList(1).get(0);

		commentService.deleteComment(writer.getId(), writtenComment.getCommentId());

		assertThat(commentService.getCommentList(1).size(), is(1));
	}

	@Test(expected = OwnerNotMatchedException.class)
	@Transactional
	public void deleteCommentWithOtherUser() {
		commentService.write(comment);
		assertThat(commentService.getCommentList(1).size(), is(2));

		Comment writtenComment = commentService.getCommentList(1).get(0);

		commentService.deleteComment("otherUser", writtenComment.getCommentId());
	}

	@Test
	@Transactional
	public void getTotalPageCount() {
		int pageCount = commentService.getTotalPageCount();
		assertThat(pageCount, is(1));

		for (int i = 0; i < 10; i++) 
			commentService.write(comment);

		pageCount = commentService.getTotalPageCount();
		assertThat(pageCount, is(2));
	}
}
