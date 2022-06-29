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
<form name=f method=POST action="/dokogacha/UserDetailServlet">
	<table border="1" style="border-collapse: collapse">
		<tr><th class="fhead" colspan="10">お気に入り一覧</th></tr>
		<tr class="tab">
			<td colspan="5" class="unselecting"><a href="/dokogacha/FavoriteReviewListServlet">お気に入り投稿一覧</a></td>
			<td colspan="5" class="selecting"><a href="/dokogacha/FavoriteUserListServlet">お気に入りユーザ一覧</a></td>
		</tr>
		<tr><td class="empty" colspan="10"></td></tr>
			<c:forEach var="e" items="${favorite_user_list}" >
				<tr class="data">
					<input type="hidden" name="user" value=${e.id}>
					<input type="hidden" name="review" value="change">
					<c:if test="${e.user_image == null}">
						<input type="hidden" value="${e.user_image = "icon_panda.png"}">
					</c:if>
					<td class="icon" colspan="2"><a href="javascript:document.f.submit()"><img src="/dokogacha/img/${e.user_image}"></a></td>
					<td class="uname" colspan="6"><a href="javascript:document.f.submit()">ユーザ名：${e.id}</a></td>
					<td class="delete" colspan="2"><input type="submit" name="follow_state" value="お気に入り解除" class="check" formaction="/dokogacha/FavoriteUserListServlet"></td>
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