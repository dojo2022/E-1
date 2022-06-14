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
 <div class="slide">
 <c:forEach var="e" items="${review_imageList}" >
	<form method="POST" action="/dokogacha/ReviewDetailServlet">
	 <input type="file" name="review_image" value="${e.review_image}">
	</form>
 </c:forEach>
 </div>

	<h2 class="goodbutton"><img src="/dokogacha/img/good_shiro.png" height="160" width="250"></h2>
	<h2 class="favoritebutton"><img src="/dokogacha/img/favo_shiro.png" height="160" width="250"></h2>

 <c:forEach var="e" items="${review_detailList}" >
	<form method="POST" action="/dokogacha/ReviewDetailServlet">
	<table>
	 <tr><td><input type="text" name="product_code" value="${e.product_code}"></td></tr>
	 <tr><td><input type="text" name="title" value="${e.title}"></td></tr>
	 <tr><td><textarea name="thought" value="${e.thought}"></textarea></td></tr>
	 <tr><td><input type="text" name="price" value="${e.price}"></td></tr>
	 <tr><td><input type="text" name="address" value="${e.address}"></td></tr>
	 <tr><td><input type="radio" name="evalution" value="${e.evalution}"></td></tr>
	 <tr><td>アイコン</td>
	     <td rowspan="2"><input type="text" name="user_name" value="${e.user_name}"></td></tr>
	</table>
	</form>
	<hr>
 </c:forEach>

<a href="/dokogacha/UserDatailResultServlet"><img src="/dokogacha/img/detail_user.png" height="160" width="250"></a>
<a href="/dokogacha/SearchResultServlet"><img src="/dokogacha/img/cap_back.png" height="160" width="250"></a>
<a href="/dokogacha/TopServlet"><img src="/dokogacha/img/cap_top.png" height="160" width="250"></a>
</body>
</html>