package kr.ac.jejunu.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.ac.jejunu.model.Comment;

public class CommentDao extends SqlSessionDaoSupport {

	public List<Comment> getCommentsByPage(int page) {
		int offset = (page - 1) * 10;
		return getSqlSession().selectList("commentDao.getCommentsByPage", offset);
	}

}
