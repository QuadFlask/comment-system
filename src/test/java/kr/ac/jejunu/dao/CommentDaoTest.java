package kr.ac.jejunu.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.ac.jejunu.model.Comment;

import static org.hamcrest.core.Is.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class CommentDaoTest {

	@Autowired
	CommentDao commentDao;

	@Test
	public void getComments() {
		int page = 1;
		List<Comment> comments = commentDao.getComments(page);
		assertThat(comments.size(), is(1));
	}
}
