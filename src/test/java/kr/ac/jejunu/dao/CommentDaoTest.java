package kr.ac.jejunu.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejunu.model.Comment;
import static org.hamcrest.core.Is.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
