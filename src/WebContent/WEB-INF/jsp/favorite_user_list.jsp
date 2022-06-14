<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お気に入り一覧(ユーザ)</title>
</head>
<body>
<div class="wrapper">
	<form method="POST" action="/simpleBC/RegistServlet">
		<table border="1" style="border-collapse: collapse">
			<tr><th class="fhead" colspan="10">お気に入り一覧</th></tr>
			<tr class="tab">
				<td colspan="5"><a href="https://www.yahoo.co.jp/">お気に入り投稿一覧</a></td>
				<td colspan="5" class="selecting"><a href="https://www.yahoo.co.jp/">お気に入りユーザ一覧</a></td>
			<tr><td class="empty" colspan="10"></td></tr>
			</tr>
			<c:forEach var="e" items="${faorite_user_list}" >
			<tr class="data">
				<td class="icon" colspan="2"><a href="https://www.yahoo.co.jp/">icon</a></td>
				<td class="uname" colspan="8"><a href="https://www.yahoo.co.jp/">鈴木<input type="checkbox" name="follow_state" value="お気に入り解除" class="check"></a></td>
			</tr>
			<tr class="data">
				<td class="icon" colspan="2"><a href="https://www.yahoo.co.jp/">icon</a></td>
				<td class="uname" colspan="8"><a href="https://www.yahoo.co.jp/">山田<input type="checkbox" name="follow_state" value="お気に入り解除" class="check"></a></td>
			</tr>
			<tr class="data">
				<td class="icon" colspan="2"><a href="https://www.yahoo.co.jp/">icon</a></td>
				<td class="uname" colspan="8"><a href="https://www.yahoo.co.jp/">田川<input type="checkbox" name="follow_state" value="お気に入り解除" class="check"></a></td>
			</tr>
			<tr class="data">
				<td class="icon" colspan="2"><a href="https://www.yahoo.co.jp/">icon</a></td>
				<td class="uname" colspan="8"><a href="https://www.yahoo.co.jp/">中村<input type="checkbox" name="follow_state" value="お気に入り解除" class="check"></a></td>
			</tr>
			</c:forEach>
			<tr class="menu">
				<td colspan="2" class="back"><a href="https://www.yahoo.co.jp/"><img src="images/cap_back.png" alt="戻る"></a></td>
				<td colspan="6" class="emp"></td>
				<td colspan="2" class="top"><a href="https://www.yahoo.co.jp/"><img src="images/cap_top.png" alt="トップ"></a></td>
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
		.tab {
			text-align: center;
		}
		td.selecting {
			background-color: #ff6347;
		}
		.check {
			position: relative;
			left: 300px;
		}
		.fhead, .tab, .empty {
			height: 50px;
		}
		td.empty{
			background-color: #c0c0c0;
		}
		tr.menu{
			background-color: #c0c0c0;
			height: 120px;
		}
		.data {
			padding: max;
			height: 100px;
		}
		.tab td:hover {
		    background: gray;
		}
		.ne:hover {
		    background: gray;
		}
		.data:hover {
		    background: gray;
		}
		.tab td a {
			display: block;
		}
		.data td a {
			display: block;
			height: 100px;
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
		}
		.uname {
			text-align: center;
			font-size: 150%;
		}
		.back img,.top img{
			text-align:center;
			vertical-align:middle;
			width: 80px;
			height: 80px;
		}
		</style>
	</form>
</div>
</body>
</html>