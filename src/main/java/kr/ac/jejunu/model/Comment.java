package kr.ac.jejunu.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Comment {
	private int commentId;
	private User writer;
	private String contents, regdttm, prettyDateTime;
	private int recommendationCount, oppositionCount;

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

		try {
			SimpleDateFormat s = new SimpleDateFormat("yyyyMMddhhmm");
			Date date = s.parse(regdttm);
			Date now = Calendar.getInstance().getTime();

			SimpleDateFormat s2;
			if (date.getYear() == now.getYear() && date.getMonth() == now.getMonth() && date.getDate() == now.getDate()) {
				s2 = new SimpleDateFormat("hh:mm");
			} else {
				s2 = new SimpleDateFormat("yyyy.MM.dd");
			}
			prettyDateTime = s2.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getPrettyDateTime() {
		return prettyDateTime;
	}

	public int getRecommendationCount() {
		return recommendationCount;
	}

	public void setRecommendationCount(int recommendationCount) {
		this.recommendationCount = recommendationCount;
	}

	public int getOppositionCount() {
		return oppositionCount;
	}

	public void setOppositionCount(int oppositionCount) {
		this.oppositionCount = oppositionCount;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", writer=" + writer + ", contents=" + contents + ", regdttm="
				+ regdttm + ", recommendationCount=" + recommendationCount + ", oppositionCount=" + oppositionCount
				+ "]";
	}

}
