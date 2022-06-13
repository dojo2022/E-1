<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<a href="/dokogacha/RegistServlet"></a>
		<form method="POST" action="/dokogacha/LoginServlet">
			<img src="/dokogacha/img/cap_username.png">
			<input type="text" name="user_name">
			<img src="/dokogacha/img/cap_password.png">
			<input type="password" name="password" placeholder="半角英数８文字以上１６文字以内">
			<input type="submit" name="login" value="ログイン">

		</form>
	</body>
</html>