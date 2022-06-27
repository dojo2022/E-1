<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/favorite_review_list.css">
<script src="js/favorite_review_list.js"></script>
<meta charset="UTF-8">
<title>お気に入り一覧(レビュー)</title>
</head>
<body>
<div class="wrapper">
	<form name=f method=POST action="/dokogacha/FavoriteReviewListServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10">お気に入り一覧</th></tr>
			<tr class="tab">
				<td colspan="5" class="selecting"><a href="/dokogacha/FavoriteReviewListServlet">お気に入り投稿一覧</a></td>
				<td colspan="5" class="unselecting"><a href="/dokogacha/FavoriteUserListServlet">お気に入りユーザ一覧</a></td>
			</tr>
			<tr><td class="empty" colspan="10"></td></tr>
			<c:forEach var="e" items="${favorite_review_list}" >
			<tr class="data">
				<input type="hidden" name="review_id" value=${e.review_id}>
				<input type="hidden" name="review" value="change">
				<td class="icon" colspan="2"><a href="javascript:document.f.submit()"><img src="/dokogacha/img/${e.image}" alt="戻る"></a></td>
				<td class="detail" colspan="6"><a href="javascript:document.f.submit()">
				<div class="top">ジャンル：${e.genre_name} / 値段：${e.price}円</div><br>
				<div class="middle">商品名：${e.puroduct_name}</div><br>
				<div class="bottom">いいね数：${e.good}</div></a></td>
				<td class="delete" colspan="2"><input type="submit" name="follow_state" value="お気に入り解除" class="check" formaction="/dokogacha/FavoriteReviewListServlet"></td>
			</tr>
			</c:forEach>

			<tr class="menu">
				<td colspan="2" class="back"><a href="/dokogacha/MypageServlet"><img src="/dokogacha/img/cap_back.png" alt="戻る"></a></td>
				<td colspan="6" class="emp"></td>
				<td colspan="2" class="top"><a href="/dokogacha/TopServlet"><img src="/dokogacha/img/cap_top.png" alt="トップ"></a></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>