<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/common.css">
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/top.css">
</head>
<body>
<div class="wrapper">
<!-- ヘッダー -->
<header class="header">
  <h1 class="logo">トップページ</h1>
  <nav class="nav">
  <div class="opcap">
    <ul>
    <li><a href="/dokogacha/SearchServlet">
    <img class="opcap_search" src="/dokogacha/img/opcap_search.png" alt="検索">
    <img class="cap_search" src="/dokogacha/img/cap_search.png" alt="検索"></a></li>
   </ul>
    </div>
    <div class="opcap2">
    <ul>
    <li><a href="/dokogacha/ReviewServlet">
    <img class="opcap_post" src="/dokogacha/img/opcap_post.png" alt="投稿">
    <img class="cap_post" src="/dokogacha/img/cap_post.png" alt="投稿"></a></li>
    </ul>
    </div>
    <div class="opcap3">
    <ul>
    <li><a href="/dokogacha/MypageServlet">
    <img class="opcap_mypage" src="/dokogacha/img/opcap_mypage.png" alt="マイページ">
    <img class="cap_mypage" src="/dokogacha/img/cap_mypage.png" alt="マイページ"></a></li>
    </ul>
    </div>
    <div class="opcap4">
    <a href="/dokogacha/LogoutServlet">
    <img class="opcap_logout" src="/dokogacha/img/opcap_logout.png" alt="ログアウト">
    <img class="cap_logout" src="/dokogacha/img/cap_logout.png" alt="ログアウト">
    </a>
    </div>
    </nav>
    </header>
    <img class="button_null" src="/dokogacha/img/button_null.png">
    <div class ="trend_review">
	<table border="1" style="border-collapse: collapse">
			<tr><td class="empty"></td></tr>
			<c:forEach var="e" items="${trend_review}" >
			<tr><td class="icon"><img class="icon2"  src = "/dokogacha/img/shiro_panda.png"><!---${e.image}---></td></tr>
			<tr class="data">
				<td class="detail">
				<div class="top">${e.genre_name} / ${e.price}</div><br>
				<div class="middle">${e.puroduct_name}</div><br>
				<div class="bottom">${e.good}</div></td>
			</tr>
			</c:forEach>
		</table>
    </div>
    </div>
</body>
<!-- フッター -->
</html>