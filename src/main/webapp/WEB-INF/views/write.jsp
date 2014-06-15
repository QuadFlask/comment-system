<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>Comment system - Write</title>
		<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
	</head>
	<body>
		<div class="form_wrap">
			<form id="comment_form" action="writeAction" method="post" onsubmit="window.opener.location.reload(true);self.close()">
				<textarea id="message" name="contents"></textarea>
				<div id="btn_wrap">
					<input type="submit" id="submit_btn" value="저장"/>
					<input type="button" id="cancle_btn" value="취소" onclick="self.close()"/>
				</div>
			</form>
		</div>
	</body>
</html>