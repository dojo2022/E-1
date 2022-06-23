<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form name=f method=POST action="/dokogacha/UserReviewListServlet">
<table class="review">
			<c:forEach var="e" items="${user_review_list}" >
			<tr class="data">
				<input type="hidden" name="review_id" value=${e.review_id}>
				<input type="hidden" name="review" value="change">
				<td class="photo" colspan="2"><a href="javascript:document.f.submit()">${e.image}</a></td>
				<td class="nakami" colspan="6"><a href="javascript:document.f.submit()"><div class="top">${e.genre_name} / ${e.price}</div><br><div class="middle">${e.puroduct_name}</div><br><div class="bottom">${e.good}</div></a></td>
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
