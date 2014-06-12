<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>Comment system</title>
		<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
	</head>
	<body>
		<div class="form_wrap">
			<form id="login_form" action="loginAction" method="post">
				<label for="id">ID</label>
				<input type="text" id="id"/><br>
				<label for="password">PASSWORD</label>
				<input type="password" id="password"/><br>
				<div id="btn_wrap">
					<input type="submit" id="submit_btn" value="로그인"/>
					<input type="button" id="cancle_btn" value="취소"/>
				</div>
			</form>
		</div>
	</body>
</html>