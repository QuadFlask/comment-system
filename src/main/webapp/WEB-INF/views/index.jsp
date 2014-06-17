<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>Comment system</title>
		<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="header">
				<span id="user_info">
					<c:if test="${user != null}">
						${user.name} (${user.explanation}) 
					</c:if>
				</span>
				<button id="write_comment_btn" onclick="openWriteForm()">글쓰기</button>
			</div>
			<div id="comment_container">
			
				<c:forEach var="comment" items="${commentList}">
					<div class="comment">
						<div class="name">${comment.writer.name}</div>
						<div class="contents">${comment.contents}</div>
						<button class="recommend" onclick="markComment(this, ${comment.commentId})">추천(<span>${comment.recommendationCount}</span>)</button>
						<button class="opposite"  onclick="markComment(this, ${comment.commentId})">반대(<span>${comment.oppositionCount}</span>)</button>
						<c:if test="${comment.writer.id.equals(user.id)}">
							<button class="delete"  onclick="deleteComment(${comment.commentId})">삭제</button>
						</c:if>
						<div class="time_stamp">${comment.prettyDateTime}</div>
					</div>
				</c:forEach>
				
			</div>
			
			<div id="page_indicator">
				<c:forEach var="pageNumber" begin="1" end="${totalPageCount}">
					<c:choose>
						<c:when test="${currentPage == pageNumber}">
							<b class="page_number_item active">${pageNumber}</b>
						</c:when>
						<c:otherwise>
							<a href="/#page=${pageNumber}" class="page_number_item">${pageNumber}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			
		</div>
	</body>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script src="http://underscorejs.org/underscore-min.js"></script>
	
	<script src="/resources/script/script.js"></script>
</html>