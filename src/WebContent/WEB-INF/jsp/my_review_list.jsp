<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿一覧</title>
<link rel="stylesheet" type="text/css" href="css/my_review_list.css">

</head>
<body>
			<p>投稿一覧</p>
			<p>自分の投稿一覧</p>

<form method="POST" action="/simpleBC/RegistServlet">
	<table class="review">
		<tr>
			<td class="icon"><a href="review_detail.jsp">image</a></td>
			<td class="uname"><a href="review_detail.jsp">内容</a></td>
		</tr>
		<tr>
			<td class="icon"><a href="review_detail.jsp">image</a></td>
			<td class="uname"><a href="review_detail.jsp">内容</a></td>
		</tr>
		<tr>
			<td class="icon"><a href="review_detail.jsp">image</a></td>
			<td class="uname"><a href="review_detail.jsp">内容</a></td>
		</tr>
		<tr>
			<td class="icon"><a href="review_detail.jsp">image</a></td>
			<td class="uname"><a href="review_detail.jsp">内容</a></td>
		</tr>
		<tr class="menu">
			<td><a href="mypage.jsp"></a></td>
			<td><a href="top.jsp"></a></td>
		</tr>
	</table>
</form>

</body>
</html>