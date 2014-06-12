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
				<span id="user_info"></span>
				<button id="write_comment_btn">글쓰기</button>
			</div>
			<div id="comment_container">
			
				<c:forEach var="comment" items="${commentList}">
					<div class="comment">
						<div class="name">${comment.writer.name}</div>
						<div class="contents">${comment.contents}</div>
						<button class="recommand_btn">추천(${comment.recommendationCount})</button>
						<button class="opposite_btn">반대(${comment.oppositionCount})</button>
						<div class="time_stamp">${comment.regdttm}</div>
					</div>
				</c:forEach>
				
			</div>
		</div>
	</body>
</html>