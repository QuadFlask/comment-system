package kr.ac.jejunu.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import kr.ac.jejunu.dao.CommentDao;
import kr.ac.jejunu.model.Comment;

public class CommentDaoImpl extends SqlSessionDaoSupport implements CommentDao {

	@Override
	public List<Comment> getCommentsByPage(int page) {
		int offset = (page - 1) * 10;
		return getSqlSession().selectList("commentDao.getCommentsByPage", offset);
	}

	@Override
	public void addCommnet(Comment comment) {
		getSqlSession().insert("commentDao.addComment", comment);
	}

	@Override
	public void delete(int commentId) {
		getSqlSession().delete("commentDao.delete", commentId);
	}

	@Override
	public void incRecommendationCount(int commentId) {
		getSqlSession().update("commentDao.incRecommendationCount", commentId);
	}

}
