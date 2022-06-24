<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
//リクエストスコープからのデータの取得
int genre = (int)request.getAttribute("genre");
String word = (String)request.getAttribute("word");
String address = (String)request.getAttribute("address");
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/search_result.css">
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<div class="wrapper">
	<form name=f method=POST action="/dokogacha/SearchResultServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10"><%= genre %><%= word %><%= address %>の検索結果</th></tr>
			<tr><td class="empty1" colspan="10"></td></tr>
			<tr><td class="empty2" colspan="10"></td></tr>
				<c:forEach var="e" items="${reviewList}" >
					<tr class="data">
						<input type="hidden" name="review_id" value=${e.review_id}>
						<input type="hidden" name="review" value="change">
						<td class="icon" colspan="2"><a href="javascript:document.f.submit()">${e.image}</a></td>
						<td class="detail" colspan="8"><a href="javascript:document.f.submit()">
						<div class="top">ジャンル：${e.genre_name} / 値段：${e.price}円</div><br>
						<div class="middle">商品名：${e.puroduct_name}</div><br>
						<div class="bottom">いいね数：${e.good}</div></a></td>
					</tr>
				</c:forEach>
			<tr class="menu">
				<td colspan="2" class="back"><a href="/dokogacha/SearchServlet"><img src="/dokogacha/img/cap_back.png" alt="戻る"></a></td>
				<td colspan="6" class="emp"></td>
				<td colspan="2" class="top"><a href="/dokogacha/TopServlet"><img src="/dokogacha/img/cap_top.png" alt="トップ"></a></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>l>