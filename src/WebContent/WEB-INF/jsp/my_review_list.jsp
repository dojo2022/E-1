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
	<form name=f method=POST action="/dokogacha/MyReviewListServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10">投稿一覧</th></tr>
			<tr class="tab">
				<td colspan="10" class="selecting">自分の投稿一覧</td>
			</tr>
			<tr><td class="empty" colspan="10"></td></tr>
			<c:forEach var="e" items="${user_review_list}" >
			<tr class="data">
				<input type="hidden" name="review_id" value=${e.review_id}>
				<input type="hidden" name="review" value="change">
				<td class="icon" colspan="2"><a href="javascript:document.f.submit()">${e.image}</a></td>
				<td class="detail" colspan="6"><a href="javascript:document.f.submit()">
				<div class="top">${e.genre_name} / ${e.price}</div><br>
				<div class="middle">${e.puroduct_name}</div><br>
				<div class="bottom">${e.good}</div></a></td>
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
