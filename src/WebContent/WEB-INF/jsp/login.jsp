<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>ログイン</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="js/login.js"></script>
</head>
<body>
	<div class="wapper">
		<a href="/dokogacha/RegistServlet"><img class="img_regist"
			src="/dokogacha/img/new_resist.png"></a>
		<h1 class="h1_login">ログイン</h1>
		<form id="form_login" method="POST" action="/dokogacha/LoginServlet">
			<span id="error_message">${error_message}</span>
			<div class="div_username">
				<img class="img_username" src="/dokogacha/img/cap_username.png">
				<input class="text_username" type="text" name="id">
			</div>
			<div class="div_password">
				<img class="img_password" src="/dokogacha/img/cap_password.png">
				<input class="password_password" type="password" name="pw"
					placeholder="半角英数８文字以上１６文字以内">
			</div>
			<div class="btn">
				<input class="submit_login" type="image" name="login"
					src="/dokogacha/img/button_login2.png" onclick="submit_login()">
				<input class="submit_login" type="image" name="login"
					src="/dokogacha/img/button_login.png" onclick="submit_login()">
			</div>
		</form>
		<br> <img class="img_panda" src="/dokogacha/img/capout_panda.png">
	</div>
</body>
</html>