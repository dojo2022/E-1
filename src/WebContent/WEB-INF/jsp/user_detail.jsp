<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこがちゃ｜他ユーザの詳細</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/user_detail.css">
<!-- <style>*{outline: 1px solid #ff0000;}</style>
-->
</head>
<body>
<div class="wapper">
<!-- 修正が必要 reviewIDを渡せたら行けそう-->
<a href="#" onclick="history(-1);return false;"class="capsule_back"><img src="/dokogacha/img/cap_back.png" alt="戻る"></a>
<a href="/dokogacha/LogoutServlet" class="capsule_logout"><img src="/dokogacha/img/cap_logout.png" alt="ログアウト"></a>
<!-- ナビゲーションバー -->
<header class="header">
	<nav class="nav">
	<div class="menu">
	<ul>
	    <li><a href="/dokogacha/TopServlet">トップ</a></li>
	    <li><a href="/dokogacha/SearchServlet">検索</a></li>
	    <li><a href="/dokogacha/ReviewServlet">投稿</a></li>
	    <li><a href="/dokogacha/MypageServlet">マイページ</a></li>
	</ul>
	</div>
	</nav>
</header>
<!-- メイン -->
<!-- ユーザアイコン、ユーザ名、お気に入り投稿リンクの表示 -->

<div class ="user_inf1">
	<div class ="user_image	">
		<img src="${'/dokogacha/img/user_image/'+= user.user_image}" alt="アイコン" > <!-- /dokogacha/img/icon_panda.png -->
	</div>
	<div class ="user_name_title">
		<span class ="user_name">${user.id}</span>
		 <img src="${'/dokogacha/img/'+=title.image}" alt="称号" width=50px class="title"><br>
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
		${total_good}いいね
	</div>
	<div class="Favorite_Genre2">
		<c:forEach var="Fgenre" items="${FGList}" >
		＃${Fgenre}
		</c:forEach>
	</div>
</div>
<!-- お気に入りボタンと最新投稿、投稿一覧リンクの表示 -->
<div class="user_inf3">
	<!-- お気に入りボタン -->
	<div class="follow">
	<form method="post" action="/dokogacha/UserDetailServlet" enctype="multipart/form-data" class="form">
		<input type="image" name="follow" src="/dokogacha/img/button_userfavo.png" alt="お気に入り">
	</form>
	</div>
	<!-- 最新投稿、投稿一覧リンクの表示 -->
	<div class="review">
		<img src="/dokogacha/img/opcap_null.png" >
		<div class ="new_review">
			＃${review.ganre}<br>${review.price},${review.product_name}<br>${review.good}<br>
		</div>
		<div class ="review_list">
			<a href="/dokogacha/MyReviewListServlet"><br>${user.id}の全投稿を表示</a>
		</div>
	</div>
</div>

<!-- フッター -->
</div>
</body>
</html>