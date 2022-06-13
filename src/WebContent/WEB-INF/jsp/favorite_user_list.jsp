<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お気に入り一覧(ユーザ)</title>
</head>
<body>
<form method="POST" action="/simpleBC/RegistServlet">
	<table>
		<tr><th class="fhead" colspan="2">お気に入り一覧</th></tr>
		<tr class="tab">
			<th><a href="https://www.yahoo.co.jp/">お気に入り投稿一覧</a></th>
			<th><a href="https://www.yahoo.co.jp/">お気に入りユーザ一覧</a></th>
		</tr>
		<c:forEach var="e" items="${faorite_user_list}" >
		<tr>
			<td class="icon"><a href="https://www.yahoo.co.jp/">icon</a></td>
			<td class="uname"><a href="https://www.yahoo.co.jp/">鈴木<input type="checkbox" name="follow_state" value="お気に入り解除"></a></td>
		</tr>
		<tr>
			<td class="icon"><a href="https://www.yahoo.co.jp/">icon</a></td>
			<td class="uname"><a href="https://www.yahoo.co.jp/">山田<input type="checkbox" name="follow_state" value="お気に入り解除"></a></td>
		</tr>
		<tr>
			<td class="icon"><a href="https://www.yahoo.co.jp/">icon</a></td>
			<td class="uname"><a href="https://www.yahoo.co.jp/">田川<input type="checkbox" name="follow_state" value="お気に入り解除"></a></td>
		</tr>
		<tr>
			<td class="icon"><a href="https://www.yahoo.co.jp/">icon</a></td>
			<td class="uname"><a href="https://www.yahoo.co.jp/">中村<input type="checkbox" name="follow_state" value="お気に入り解除"></a></td>
		</tr>
		</c:forEach>
		<tr class="menu">
			<td><a href="https://www.yahoo.co.jp/">戻る</a></td>
			<td><a href="https://www.yahoo.co.jp/">トップへ</a></td>
		</tr>
	<script>
	  $('tr[data-href]').click(function (e) {
	      if (!$(e.target).is('a')) {
	        window.location = $(e.target).data('href');
	      };
	  });
	</script>
​
	<style>
	table {
		margin-left: auto;
		margin-right: auto;
	}
	#userlist {
		margin-left: auto;
		margin-right: auto;
	}
	#userlist tr:hover {
		background: red;
	}
	#userlist td a {
		display: block;
	}
	#userlist td {
		text-align: left;
	}
	.icon {
		padding: 5px 20px 5px 20px;
	}
	.uname {
​
		padding: 5px 100px 5px 100px;
	}
	</style>
</form>
</body>
</html>