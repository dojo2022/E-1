<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿一覧</title>
<link rel="stylesheet" type="text/css" href="css/my_review_list.css">
<script src="js/my_review_list.js"></script>
</head>
<body>
<div class="wrapper">
<h1>投稿一覧</h1>
<h2>自分の投稿</h2>
<form name=f method=POST action="/dokogacha/ReviewDetailServlet">
	<table class="review">
			<c:forEach var="u" items="${user_review_list}" >
			<tr class="data">
				<input type="hidden" name="review_id" value=${u.review_id}>
				<input type="hidden" name="review" value="change">
				<td class="photo"><a href="javascript:document.f.submit()">${u.image}</a></td>
				<td class="nakami" ><a href="javascript:document.f.submit()">
				<div class="kinngaku">${u.genre_name} / ${u.price}</div><br>
				<div class="naiyou">${u.puroduct_name}</div><br>
				<div class="iine">${u.good}</div></a></td>
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
