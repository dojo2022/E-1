<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこがちゃ｜他ユーザの詳細</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/common.css">
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/mypage.css">
<!-- <style>*{outline: 1px solid #ff0000;}</style>
-->

</head>
<body>
<div class="wapper">
<a href="/dokogacha/LogoutServlet" class="capsule_logout"><img src="/dokogacha/img/cap_logout.png" alt="ログアウト"></a>
<!-- ナビゲーションバー -->
<header class="header">
	<nav class="nav">
	<div class="menu">
	<ul>
	    <li><a href="index.html">トップ</a><li>
	    <li><a href="about.html">検索</a></li>
	    <li><a href="access.html">投稿</a></li>
	    <li><a href="menu.html">マイページ</a></li>
	</ul>
	</div>
	</nav>
</header>
<!-- メイン -->
<!-- ユーザアイコン、ユーザ名、お気に入り投稿リンクの表示 -->

<div class ="user_inf1">
	<div class ="user_image	">
		<img src="${user.title}" alt="アイコン" > <!-- /dokogacha/img/icon_panda.png -->
	</div>
	<div class ="user_name_title">
		<span class ="user_name">name${user.name}</span>
		 <img src="${user.title}" alt="称号" width=50px class="title"><br>
		 <a href="/dokogacha/FavoriteReviewListServlet" class="favorite_review_list">お気に入り投稿一覧</a>
	</div>
</div>

<!-- 累計いいね数とお気に入りジャンルの表示 -->
<div class="user_inf2">
	<div class="total_good1">累積いいね数 <!--ページスコープで持ってくる？--></div>
	<div class="Favorite_Genre1">お気に入りジャンル</div>
</div>
<div class="user_inf2-2">
	<div class="total_good2">
		${e.total_good}いいね
	</div>
	<div class="Favorite_Genre2">
		<c:forEach var="Ganre" items="${Ganre_list}" >
		${Ganre}<br>
		</c:forEach>
	</div>
</div>
<!-- 編集ボタンと自分の最新投稿、自分の投稿一覧リンクの表示 -->
<div class="user_inf3">
	<!-- 編集ボタン -->
	<div class="do_change"><a href="/dokogacha/MypageChangeServlet">
			<img src="/dokogacha/img/button_edit.png" alt="編集"  class="botton_edit" ></a></div>
	<!-- 自分の最新投稿、自分の投稿一覧リンクの表示 -->
	<div class="my_review">
		<img src="/dokogacha/img/opcap_null.png" >
		<div class ="my_new_review">
			＃${review.ganre}<br>${review.price},${review.product_name}<br>${review.good}<br>
		</div>
		<div class ="my_review_list">
			<a href="/dokogacha/MyReviewListServlet"><br>自分の投稿一覧へ</a>
		</div>
	</div>
</div>
<!-- フッター -->
</div>
</body>
</html>