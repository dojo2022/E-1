<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<link rel="stylesheet" type="text/css" href="css/search.css">
</head>
<body>
<div class="wrapper">
	<header class="header">
		<nav class="nav">
		<ul>
		    <li><a href="index.html">トップ</a><li>
		    <li><a href="about.html">検索</a></li>
		    <li><a href="access.html">投稿</a></li>
		    <li><a href="menu.html">マイページ</a></li>
		</ul>
		</nav>
	</header>

<form method="GET" action="result.html">
    <table>
      <tr>
        <td>
          <label><img src="/img/cap_genre.png" alt="genre">
          <input type="text" name="businesscard_id">
          </label>
        </td>
        <td>
          <label><img src="/img/cap_word.png" alt="word">
          <input type="text" name="zip_code">
          </label>
        </td>
      </tr>
      <tr>
        <td>
          <label>
          <input type="text" name="company_name">
          </label>
        </td>
		</tr>
	</table>
</form>
</div>
</body>
</html>
