<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/search_result.css">
<meta charset="UTF-8">
<title>検索結果</title>
</head>
<body>
<div class="wrapper">
	<c:set var="g" value="${g.genre}" />
	<c:set var="w" value="${w.word}" />
	<c:set var="a" value="${a.address}" />
	<form name=f method=POST action="/dokogacha/ResultDetailServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10"><c:out value="${g}" /><c:out value="${w}" /><c:out value="${a}" />の検索結果</th></tr>
			<tr><td class="empty1" colspan="10"></td></tr>
			<tr><td class="empty2" colspan="10"></td></tr>
				<c:forEach var="e" items="${review_list}" >
					<tr class="data">
						<input type="hidden" name="review_id" value=${e.reviewer_id}>
						<input type="hidden" name="review" value="change">
						<td class="icon" colspan="2"><a href="javascript:document.f.submit()">${e.image}</a></td>
						<td class="detail" colspan="8"><a href="javascript:document.f.submit()"><div class="top">${e.genre_name} / ${e.price}</div><br><div class="middle">${e.puroduct_name}</div><br><div class="bottom">${e.good}</div></a></td>
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
</html>l>