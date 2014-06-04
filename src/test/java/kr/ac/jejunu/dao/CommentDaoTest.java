package kr.ac.jejunu.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.User;
import static org.hamcrest.core.Is.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/test/java/test-context.xml")
public class CommentDaoTest {

	@Autowired
	CommentDao commentDao;

	@Test
	public void getComments() {
		int page = 1;
		List<Comment> comments = commentDao.getCommentsByPage(page);
		assertThat(comments.size(), is(1));
	}

	@Test
	@Transactional
	public void addComment() {
		Comment comment = addSampleComment();

		commentDao.addCommnet(comment);

		List<Comment> comments = commentDao.getCommentsByPage(1);
		assertThat(comments.size(), is(2));

		Comment addedComments = comments.get(0);

		assertNotSame(comment, addedComments);
		assertThat(addedComments.getWriter().getId(), is(comment.getWriter().getId()));
		assertThat(addedComments.getWriter().getName(), is(comment.getWriter().getName()));
		assertThat(addedComments.getContents(), is(comment.getContents()));
		assertThat(addedComments.getRegdttm(), is(comment.getRegdttm()));
		assertThat(addedComments.getRecommendationCount(), is(comment.getRecommendationCount()));
		assertThat(addedComments.getOppositeCount(), is(comment.getOppositeCount()));
	}

	@Test
	@Transactional
	public void deleteComment() {
		Comment comment = addSampleComment();

		commentDao.addCommnet(comment);

		List<Comment> comments = commentDao.getCommentsByPage(1);
		assertThat(comments.size(), is(2));
		commentDao.delete(comments.get(0).getCommentId());

		comments = commentDao.getCommentsByPage(1);
		assertThat(comments.size(), is(1));
	}

	private Comment addSampleComment() {
		Comment comment = new Comment();
		comment.setContents("addComment test contents");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmm");
		String regdttm = simpleDateFormat.format(Calendar.getInstance().getTime());
		comment.setRegdttm(regdttm);
		comment.setWriter(new User("pop2331", "flask", null));
		return comment;
	}
}
