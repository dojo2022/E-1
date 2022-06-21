<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/favorite_user_list.css">
<script src="js/favorite_user_list.js"></script>
<meta charset="UTF-8">
<title>お気に入り一覧(ユーザ)</title>
</head>
<body>
<div class="wrapper">
<form name=f method=POST action="/dokogacha/UserDetailtServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10">お気に入り一覧</th></tr>
			<tr class="tab">
				<td colspan="5" class="unselecting"><a href="/dokogacha/FavoriteReviewListServlet">お気に入り投稿一覧</a></td>
				<td colspan="5" class="selecting"><a href="/dokogacha/FavoriteUserListServlet">お気に入りユーザ一覧</a></td>
			</tr>
			<tr><td class="empty" colspan="10"></td></tr>
				<c:forEach var="e" items="${favorite_user_list}" >
					<tr class="data">
						<input type="hidden" name="user" value=${e.user_image}>
						<input type="hidden" name="review" value="change">
						<td class="icon" colspan="2"><a href="javascript:document.f.submit()">${e.user_image}</a></td>
						<td class="uname" colspan="8"><a href="javascript:document.f.submit()">${e.id}<input type="checkbox" name="follow_state" value="お気に入り解除" class="check"></a></td>
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