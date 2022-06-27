<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link rel="stylesheet" type="text/css" href="/dokogacha/css/search.css">
</head>
<body>
<div class="wrapper">
	<header class="header">
		<nav class="nav">
		<ul>
		    <li><a href="/dokogacha/TopServlet">トップ</a><li>
		    <li><a href="/dokogachaSearchServlet">検索</a></li>
		    <li><a href="/dokogacha/ReviewServlet">投稿</a></li>
		    <li><a href="/dokogacha/MypageServlet">マイページ</a></li>
		</ul>
		</nav>
	</header>

<form method="POST" action="/dokogacha/SearchServlet">
		<div class="capsule_genre"><img src="img/cap_genre.png" alt="genre" >
 		  <select name="genre">
          <option value="0">----ジャンルを選択する----</option>
          <c:forEach var="genre" items="${genreList}" varStatus="N">
          <option value=${genre.genre_id} >${genre.genre_name}</option>
          </c:forEach>
          </select>
		</div>
		<div class="capsule_word">
          <img src="img/cap_word.png" alt="word" >
          <input type="text" name="word">
 		</div>
		<div class="capsule_address">
          <img src="img/cap_loc.png" alt="address" >
          <input type="text" name="address">
		</div>
	<div class="btn">
		<input class="button_search2" type="image" name="login" src="img/button_search2.png" onclick="submit_login()">
		<input class="button_search" type="image" name="login" src="img/button_search.png" onclick="submit_login()">
	</div>
</form>
	<div class="opcap">
	 <a href="logout.jsp">
	 <img src="img/opcap_logout.png" alt="logout" class="opcapsule_logout">
	 <img src="img/cap_logout.png" alt="logout" class="capsule_logout">
	 </a>
	</div>
</div>
</body>
</html>