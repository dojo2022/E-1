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
	<form name=f method=POST action="/dokogacha/UserReviewListServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10">投稿一覧</th></tr>
			<tr class="tab">
			<td colspan="10" class="selecting">ユーザ投稿一覧</td>
			</tr>
			</table>
			<div class="slide">
			<table border="1" style="border-collapse: collapse">
			<tr><td class="empty" colspan="10"></td></tr>
			<c:forEach var="e" items="${user_review_list}" >
			<tr class="data">
				<input type="hidden" name="review_id" value=${e.review_id}>
				<input type="hidden" name="review" value="change">
				<td class="icon" colspan="2"><a href="javascript:document.f.submit()">${e.image}</a></td>
				<td class="detail" colspan="8"><a href="javascript:document.f.submit()">
				<div class="top">${e.genre_name} / ${e.price}</div><br>
				<div class="middle">${e.puroduct_name}</div><br>
				<div class="bottom">${e.good}</div></a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
				<div class="opcap1">
				<a href="/dokogacha/MypageServlet">
				<img src="/dokogacha/img/opcap_back.png" alt="戻る" class="opback" >
				<img src="/dokogacha/img/cap_back.png" alt="戻る" class="capback"></a>
				</div>

				<div class="opcap2">
				<a href="/dokogacha/TopServlet">
				<img src="/dokogacha/img/opcap_top.png" alt="トップ" class="optop">
				<img src="/dokogacha/img/cap_top.png" alt="トップ" class="captop"></a>
				</div>
	</form>
</div>
</body>
</html>
