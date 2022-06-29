<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/regist.css">
<meta charset="UTF-8">
<title>ユーザ登録</title>
<script src="js/regist.js"></script>
</head>
<body>
	<div class="wapper">
		<h1 class="h1_regist">ユーザ登録</h1>
		<form id="form_regist" method="POST" action="/dokogacha/RegistServlet">
			<span id="error_message"></span>
			<div class="div_username">
				<img class="img_username" src="/dokogacha/img/cap_username.png">
				<input class="text_username" type="text" name="id">
			</div>
			<div class="div_password">
				<img class="img_password" src="/dokogacha/img/cap_password.png">
				<input class="password_password" type="password" name="pw"
					placeholder="半角英数８文字以上１６文字以内">
			</div>
			<input class="submit_regist" type="image" name="regist"
				src="/dokogacha/img/button_resist.png" onclick="submit_regist()">
		</form>
	</div>
</body>
</html>