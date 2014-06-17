$(window).on('hashchange', 
	function () {
		var page = parseInt(window.location.hash.substring(6));
		if (!isNaN(page)) getCommentList(page);
	}
);
var commentTemplate = 
'<div class="comment">'+
	'<div class="name"><%print(comment.writer.name)%></div>'+
	'<div class="contents"><%=comment.contents%></div>'+
	'<button class="recommend" onclick="markComment(this, <%=comment.commentId%>)">추천(<span><%=comment.recommendationCount%></span>)</button> '+
	'<button class="opposite"  onclick="markComment(this, <%=comment.commentId%>)">반대(<span><%=comment.oppositionCount%></span>)</button>'+
	'<% if (user != null && comment.writer.id == user.id) {%> <button class="delete" onclick="deleteComment(<%=comment.commentId%>)">삭제</button> <%}%>'+
	'<div class="time_stamp"><%=comment.prettyDateTime%></div>'+
'</div>';
var pageIndicatorTemplate =
'<% if(currentPage == pageNumber){ %> <b class="page_number_item active"><%=pageNumber%></b> <%} else {%> <a href="/#page=<%=pageNumber%>" class="page_number_item"><%=pageNumber%></a> <%}%>';

function getCommentList(page){
	$.ajax(
		{
			url: "/.json?page=" + page,
			dataType: "json",
			success: function(data){
				if(data.commentList.length > 0){
					window.location.hash = "page=" + page;
					
					var html = '';
					_.each(data.commentList, function(commentData){
						html += _.template(commentTemplate, {"comment": commentData, "user": data.user});
					});
					
					var container = $('#comment_container');
					container.empty();
					container.append(html);
					
					var pageIndicator = $("#page_indicator");
					pageIndicator.empty();
					for(var pageNumber = 1; pageNumber <= data.totalPageCount; pageNumber++)
						pageIndicator.append(_.template(pageIndicatorTemplate, {"currentPage": data.currentPage, "pageNumber": pageNumber}));
				}
			},
			error: function(o,c,m){
				console.log("error occur"+o+c+m);
			}
		}	
	);
}
function deleteComment(commentId){
	if (confirm("댓글을 삭제하시겠습니까?"))
		$.ajax(
			{
				url: "/comment/" + commentId + "/delete.json",
				dataType: "json",
				success: function (data){
					if(data.actionResult.result == "success"){
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
			url: "/comment/" + commentId + "/" + btn.className + ".json",
			dataType: "json",
			success: function (data){
				if(data.actionResult.result == "success"){
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