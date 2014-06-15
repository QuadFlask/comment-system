package kr.ac.jejunu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.jejunu.dao.CommentDao;
import kr.ac.jejunu.model.Comment;

import org.mybatis.spring.support.SqlSessionDaoSupport;

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

	@Override
	public void incOppositionCount(int commentId) {
		getSqlSession().update("commentDao.incOppositionCount", commentId);
	}

	@Override
	public boolean isRecommendedCommentBy(String userId, int commentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("commentId", commentId);
		return Integer.parseInt(getSqlSession().selectOne("commentDao.isRecommendedCommentBy", param).toString()) == 1;
	}

	@Override
	public void markAsRecommendBy(String userId, int commentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("commentId", commentId);
		getSqlSession().insert("commentDao.markAsRecommendBy", param);
	}

	@Override
	public boolean isOppositedCommentBy(String userId, int commentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("commentId", commentId);
		return Integer.parseInt(getSqlSession().selectOne("commentDao.isOppositedCommentBy", param).toString()) == 1;
	}

	@Override
	public void markAsOppositeBy(String userId, int commentId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", userId);
		param.put("commentId", commentId);
		getSqlSession().insert("commentDao.markAsOppositeBy", param);
	}

	@Override
	public Comment getCommentById(int commentId) {
		return getSqlSession().selectOne("commentDao.getCommentById", commentId);
	}

	@Override
	public int getCommentsCount() {
		return getSqlSession().selectOne("commentDao.getCommentsCount");
	}

	@Override
	public boolean isMarkedCommentBy(String userId, int commentId) {
		return isRecommendedCommentBy(userId, commentId) || isOppositedCommentBy(userId, commentId);
	}

}
