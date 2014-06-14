package kr.ac.jejunu.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejunu.dao.CommentDao;
import kr.ac.jejunu.exception.DuplicatedRequestException;
import kr.ac.jejunu.exception.OwnerNotMatchedException;
import kr.ac.jejunu.model.Comment;

@Service
public class CommentService {

	@Autowired
	CommentDao commentDao;

	public List<Comment> getCommentList(int page) {
		return commentDao.getCommentsByPage(page);
	}

	public void write(Comment comment) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmm");
		String regdttm = simpleDateFormat.format(Calendar.getInstance().getTime());
		comment.setRegdttm(regdttm);
		commentDao.addCommnet(comment);
	}

	public void recommendComment(String userId, int commentId) {
		if (!commentDao.isRecommendedCommentBy(userId, commentId)) {
			commentDao.incRecommendationCount(commentId);
			commentDao.markAsRecommendBy(userId, commentId);
		} else
			throw new DuplicatedRequestException();
	}

	public void oppositeComment(String userId, int commentId) {
		if (!commentDao.isOppositedCommentBy(userId, commentId)) {
			commentDao.incOppositionCount(commentId);
			commentDao.markAsOppositeBy(userId, commentId);
		} else
			throw new DuplicatedRequestException();
	}

	public void deleteComment(String id, int commentId) {
		Comment comment = commentDao.getCommentById(commentId);
		if (comment != null && comment.getWriter().getId().equals(id))
			commentDao.delete(commentId);
		else
			throw new OwnerNotMatchedException();
	}

}
