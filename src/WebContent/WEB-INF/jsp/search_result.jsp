<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10"><c:out value="${g}" /><c:out value="${w}" /><c:out value="${a}" />の検索結果</th></tr>
			<tr><td class="empty1" colspan="10"></td></tr>
			<tr><td class="empty2" colspan="10"></td></tr>
			<c:forEach var="e" items="${favorite_review_list}" >
			<tr class="data">
				<td class="icon" colspan="2"><a href="/dokogacha/ReviewDetailServlet">review_image</a></td>
				<td class="detail" colspan="8"><a href="/dokogacha/ReviewDetailServlet"><p class="one">${e.genre}/${e.price}</p><p class="two">${e.product_code}</p><p class="three">${e.good}</p></a></td>
			</tr>
			</c:forEach>
			<tr class="menu">
				<td colspan="2" class="back"><a href="/dokogacha/MypageServlet"><img src="images/cap_back.png" alt="戻る"></a></td>
				<td colspan="6" class="emp"></td>
				<td colspan="2" class="top"><a href="/dokogacha/TopServlet"><img src="images/cap_top.png" alt="トップ"></a></td>
			</tr>
		</table>
		<script>
		  $('tr[data-href]').click(function (e) {
		      if (!$(e.target).is('a')) {
		        window.location = $(e.target).data('href');
		      };
		  });
		</script>
</div>
</body>
</html>l>