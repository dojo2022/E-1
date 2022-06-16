<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レビュー詳細画面</title>
<link rel="stylesheet" type="text/css" href="/dokogacha/css/review_detail.css">
</head>
<body>
	<div class="insert_image"><input type="file" name="insert_image" accept="image/jpeg, image/png"></div>
	<h2 class="goodbutton"><img src="/dokogacha/img/good_shiro.png" height="80" width="180" alt="good"></h2>
	<h2 class="favoritebutton"><img src="/dokogacha/img/favo_shiro.png" height="80" width="180" alt="favorite"></h2>

	<c:forEach var="e" items="${review_detailList}" >
	 <form method="POST" action="/dokogacha/ReviewDetailServlet">
	 <table class="review_detail">
	  <tr><td><input type="text" name="product_code" value="${e.product_code}"></td></tr>
	  <tr><td><input type="text" name="title" value="${e.title}"></td></tr>
	  <tr><td><textarea name="thought" value="${e.thought}"></textarea></td></tr>
	  <tr><td><input type="text" name="price" value="${e.price}"></td></tr>
	  <tr><td><input type="text" name="address" value="${e.address}"></td></tr>
	  <tr><td><input type="radio" name="star" value="${e.evalution}"></td></tr>
	 </table>
   <table cellspacing="20" class="user_detail">
    <tr><td class="icon"><img src="/dokogacha/UserDatailServlet" alt="icon"></td>
		 	  <td class="user_name"><input type="text" name="user_name" value="${e.user_name}"></td>
			  <td class="user_detail"><a href="/dokogacha/UserDatailResultServlet"><img src="/dokogacha/img/detail_user.png" height="50" width="180"></a></td></tr>
	 </table>
	 </form>
  </c:forEach>
  <hr>

  <nav class="nav">
   <ul>
    <li><a href="/dokogacha/SearchResultServlet"><img class="return" src="/dokogacha/img/cap_back.png" height="80" width="140"></a></li>
    <li><a href="/dokogacha/TopServlet"><img class="top" src="/dokogacha/img/cap_top.png" height="80" width="140"></a></li>
   </ul>
  </nav>

</body>
</html>