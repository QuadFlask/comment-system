package kr.ac.jejunu.model;

public class Comment {
	private int commentId;
	private User writer;
	private String contents, regdttm;
	private int recommendationCount, oppositeCount;

	public Comment() {
		super();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public User getWriter() {
		return writer;
	}

	public void setWriter(User writer) {
		this.writer = writer;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdttm() {
		return regdttm;
	}

	public void setRegdttm(String regdttm) {
		this.regdttm = regdttm;
	}

	public int getRecommendationCount() {
		return recommendationCount;
	}

	public void setRecommendationCount(int recommendationCount) {
		this.recommendationCount = recommendationCount;
	}

	public int getOppositeCount() {
		return oppositeCount;
	}

	public void setOppositeCount(int oppositeCount) {
		this.oppositeCount = oppositeCount;
	}

}
