package kr.ac.jejunu.dao;

import java.util.List;

import kr.ac.jejunu.model.Comment;

public interface CommentDao {

	public abstract List<Comment> getCommentsByPage(int page);

	public abstract void addCommnet(Comment comment);

	public abstract void delete(int commentId);

	public abstract void incRecommendationCount(int commentId);

	public abstract void incOppositionCount(int commentId);

	public abstract boolean isRecommendedCommentBy(String userId, int commentId);

	public abstract void markAsRecommendBy(String userId, int commentId);

	public abstract boolean isOppositedCommentBy(String userId, int commentId);

	public abstract void markAsOppositeBy(String userId, int commentId);

	public abstract Comment getCommentById(int commentId);

}