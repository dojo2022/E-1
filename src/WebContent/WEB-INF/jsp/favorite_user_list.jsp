<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/favorite_user_list.css">
<meta charset="UTF-8">
<title>お気に入り一覧(ユーザ)</title>
</head>
<body>
<div class="wrapper">
	<form method="POST" action="/dokogacha/FavoriteUserListServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10">お気に入り一覧</th></tr>
			<tr class="tab">
				<td colspan="5" class="unselecting"><a href="/dokogacha/FavoriteReviewListServlet">お気に入り投稿一覧</a></td>
				<td colspan="5" class="selecting"><a href="/dokogacha/FavoriteUserListServlet">お気に入りユーザ一覧</a></td>
			</tr>
			<tr><td class="empty" colspan="10"></td></tr>
			<c:forEach var="e" items="${faorite_user_list}" >
			<tr class="data">
				<td class="icon" colspan="2"><a href="/dokogacha/UserDatailServlet">${e.icon}ユーザ画像</a></td>
				<td class="uname" colspan="8"><a href="/dokogacha/UserDatailServlet">${e.reviewer_profile}ユーザ名<input type="checkbox" name="follow_state" value="お気に入り解除" class="check"></a></td>
			</tr>
			</c:forEach>
			<tr class="menu">
				<td colspan="2" class="back"><a href="/dokogacha/MypageServlet"><img src="/dokogacha/img/cap_back.png" alt="戻る"></a></td>
				<td colspan="6" class="emp"></td>
				<td colspan="2" class="top"><a href="/dokogacha/TopServlet"><img src="/dokogacha/img/cap_top.png" alt="トップ"></a></td>
			</tr>
		</table>
		<script>
		  $('tr[data-href]').click(function (e) {
		      if (!$(e.target).is('a')) {
		        window.location = $(e.target).data('href');
		      };
		  });
		</script>
	</form>
</div>
</body>
</html>