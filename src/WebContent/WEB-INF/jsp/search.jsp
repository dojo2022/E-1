<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link rel="stylesheet" type="text/css" href="dokogacha/css/search.css">
</head>
<body>
<div class="wrapper">
	<header class="header">
		<nav class="nav">
		<ul>
		    <li><a href="index.html">トップ</a><li>
		    <li><a href="about.html">検索</a></li>
		    <li><a href="access.html">投稿</a></li>
		    <li><a href="menu.html">マイページ</a></li>
		</ul>
		</nav>
	</header>

<form method="POST" action="result.html">
		<div class="capsule_genre"><img src="img/cap_genre.png" alt="genre" >
 		  <select name="genre" required>
          <option value="">----ジャンルを選択する----</option>
          <c:forEach var="genre" items="${genreList}" varStatus="N">
          <option value="${N.count}" >${genre.name}</option>
          </c:forEach>
          </select>
		</div>
		<div class="capsule_word">
          <img src="img/cap_word.png" alt="word" >
          <input type="text" name="cap_word">
 		</div>
		<div class="capsule_address">
          <img src="img/cap_loc.png" alt="address" >
          <input type="text" name="capsule_address">
		</div>
</form>
	<div class="btn">
	 <a href="search_result.jsp">
		<img src="img/button_search2.png" alt="search" class="button_search2">
		<img src="img/button_search.png" alt="search" class="button_search">
	 </a>
	</div>
	<div class="opcap">
	 <a href="logout.jsp">
	 <img src="img/opcap_logout.png" alt="logout" class="opcapsule_logout">
	 <img src="img/cap_logout.png" alt="logout" class="capsule_logout">
	 </a>
	</div>
</div>
</body>
</html>