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