<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お気に入り一覧(ユーザ)</title>
</head>
<body>
<div class="wrapper">
		<c:set var="g" value="${s.genre}" />
		<c:set var="w" value="${s.word}" />
		<c:set var="a" value="${s.address}" />
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
		<style>
		.wrapper {
  			margin: 0 auto 0 auto;
		}
		table {
			margin-left: auto;
			margin-right: auto;
			text-align: left;
			table-layout: fixed;
			width: 80%;
		}
		.fhead {
			text-align: center;
		}
		.check {
			position: relative;
			left: 30px;
		}
		.fhead, .empty1, .empty2 {
			height: 50px;
		}
		td.empty1{
			background-color: #c0c0c0;
		}
		td.empty2{
			background-color: #c0c0c0;
		}
		tr.menu{
			background-color: #c0c0c0;
			height: 120px;
		}
		.data {

		}
		.ne:hover {
		    background: gray;
		}
		.data:hover {
		    background: gray;
		}
		.data td a {
			display: block;
			height: 30px;
		}
		.emp {
			border-right: none;
			border-left: none;
		}
		.back {
			border-right: none;
		}
		.top {
			border-left: none;
		}
		.icon {
			height: 100px;
			line-height: 100px;
		}
		.detail {
			line-height: 100px;
			font-size: 100%;
		}
		.back img,.top img{
			text-align:center;
			vertical-align:middle;
			width: 80px;
			height: 80px;
		}
		p {
			display: inline-block;

		}
		.one {
			vertical-align: middle;
		}
		</style>
</div>
</body>
</html>l>