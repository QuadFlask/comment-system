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
					</c:if></span>
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
		</div>
	</body>
	<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
	<script type="text/javascript">
		function deleteComment(commentId){
			if (confirm("댓글을 삭제하시겠습니까?"))
				$.ajax(
					{
						url: "/comment/" + commentId + "/delete",
						dataType: "json",
						success: function (data){
							if(data.result == 'success'){
								alert("삭제되었습니다.");
								location.reload(true);
							}
						},
						error: function(o,c,m){
							alert("삭제 실패" + o + c + m);
						}
					}
				);
		} 
		function markComment(btn, commentId){
			$.ajax(
				{
					url: "/comment/" + commentId + "/" + btn.className,
					dataType: "json",
					success: function (data){
						if(data.result == 'success'){
							var tag = btn.getElementsByTagName("span")[0];
							var currentCount = parseInt(tag.innerHTML);
							tag.innerHTML = currentCount + 1;
						}
					},
					error: function (o,c,m){
						openLoginForm();
					}
				}
			);
		}
		function openLoginForm(){
			window.open('/login', 'login', 'width=400, height=250');
		}
		function openWriteForm(){
			window.open('/write', 'write', 'width=400, height=250');
		}
	</script>
</html>