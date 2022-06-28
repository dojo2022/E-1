<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>レビュー詳細画面</title>
<link rel="stylesheet" type="text/css" href="/dokogacha/css/review_detail.css">
</head>
<body>

	<form method="POST" action="/dokogacha/ReviewDetailServlet">
		<c:forEach var="review_image" items="${review_imageList}" >
			<div class="review_image">
			<div class="out">
			<img src="/dokogacha/img/${review_image.image}" alt="Not Image">
				<input type=radio name="slide" id="slide1">
    			<input type=radio name="slide" id="slide2">
    			<input type=radio name="slide" id="slide3">
    			<input type=radio name="slide" id="slide4">
    		<div class="in">
        		<label for="slide1"><span></span><a href="#1"><img src="/dokogacha/img/${review_image.image}" alt="Not Image1"></a></label>
        		<label for="slide2"><span></span><a href="#2"><img src="/dokogacha/img/${review_image.image}" alt="Not Image2"></a></label>
        		<label for="slide3"><span></span><a href="#3"><img src="/dokogacha/img/${review_image.image}" alt="Not Image3"></a></label>
        		<label for="slide4"><span></span><a href="#4"><img src="/dokogacha/img/${review_image.image}" alt="Not Image4"></a></label>
    		</div>
			</div>
			</div>
		</c:forEach>
		<h2 class="goodbutton"><img id="goodbutton" name="goodbutton" value="いいねボタン" src="/dokogacha/img/good_shiro.png" height="80" width="180" onclick="change1()"></h2>
		<h2 class="favoritebutton"><img id="favoritebutton" name="favoritebutton" value="お気に入りボタン" src="/dokogacha/img/favo_shiro.png" height="80" width="180" onclick="change2()"></h2>
		<c:forEach var="e" items="${review_detailList}" >
		<table class="review_detail">
			<tr><td>商品名<input type="text" name="product_code" value="${e.puroduct_name}"></td></tr>
			<tr><td>タイトル<input type="text" name="title" value="${e.title}"></td></tr>
			<tr><td>感想・説明<input type="text" name="thought" value="${e.thought}"></td></tr>
			<tr><td>値段（円）<input type="text" name="price" value="${e.price}"></td></tr>
			<tr><td>住所<input type="text" name="address" value="${e.address}"></td></tr>
			<tr><td>5段階評価<input type="text" name="star" value="${e.evalution}"></td></tr>
		</table>
		<table class="user_detail" >
			<tr><td class="icon"><img src="/dokogacha/UserDatailServlet" alt="icon"></td>
			<td class="user_name"><input type="text" name="user_name" value="${e.user_name}"></td>
			<td class="user_detail"><a href="/dokogacha/UserDetailServlet"><img src="/dokogacha/img/detail_user.png" height="50" width="180"></a></td></tr>
		</table>
		</c:forEach>
	</form>


  <nav class="nav">
   <ul>
    <li><a href="#" onclick="history.back(-1);return false;"><img class="return" src="/dokogacha/img/cap_back.png" height="100" width="140"></a></li>
    <li><a href="/dokogacha/TopServlet"><img class="top" src="/dokogacha/img/cap_top.png" height="100" width="140"></a></li>
   </ul>
  </nav>
<script type="text/javascript" src="/dokogacha/js/review_detail.js"></script>
</body>
</html>