<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿一覧</title>
<link rel="stylesheet" type="text/css" href="css/user_review_list.css">
<script src="js/user_review_list.js"></script>
</head>
<body>
<div class="wrapper">
<h1>投稿一覧</h1>
<h2>他ユーザーの投稿</h2>
<form name=f method=POST action="/dokogacha/ReviewDetailServlet">
	<table class="review">
		<c:forEach var="e" items="${user_review_list}" >
		<tr  class="deta">
			<input type="hidden" name="review" value="change">
			<c:set var="no" value="${e.reviewer_name}"/>
			<td class="photo"><a href="javascript:document.f.submit()"><img src="img/icon_camera.png" id=""></a></td>
			<td class="nakami"><a href="javascript:document.f.submit()"><div class="kinngaku">${e.genre}ジャンル/値段${e.price}</div><br><div class="naiyou">${e.product_code}商品名</div><br><div  class="iine">${e.good}いいね数</div></a></td>
		</tr>
	</c:forEach>
	</table>
</form>
	<div class="back">
	 <a href="search_result.jsp">
		<img src="img/opcap_back.png" alt="search" class="opcap_back">
		<img src="img/cap_back.png" alt="search" class="cap_back">
	 </a>
	</div>
	<div class="totop">
	 <a href="logout.jsp">
	 <img src="img/opcap_top.png" alt="logout" class="opcapsule_top">
	 <img src="img/cap_top.png" alt="logout" class="capsule_top">
	 </a>
	</div>
</div>
</body>
</html>
