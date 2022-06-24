<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこがちゃ｜マイページ</title>
<link rel= "stylesheet" type="text/css" href ="/dokogacha/css/mypage.css">
<!----><style>*{outline: 1px solid #ff0000;}</style>

</head>
<body>
<div class="wapper">
<a href="/dokogacha/LogoutServlet" class="capsule_logout"><img src="/dokogacha/img/cap_logout.png" alt="ログアウト"></a>
<!-- ナビゲーションバー UserDetailServlet-->
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
	<div class ="user_image">
		<img src="${'/dokogacha/img/user_image/'+= user.user_image}" alt="アイコン" height=120px > <!-- /dokogacha/img/shiro_panda.png -->
	</div>
	<div class ="user_name_title">
		<span class ="user_name">${user.id}</span>
		<img src="+${'/dokogacha/img/'+=title.image}" alt="称号なし"  class="title" ><br> <!-- /dokogacha/img/shiro_panda.png -->
		 <a href="/dokogacha/FavoriteReviewListServlet" class="favorite_review_list">お気に入り投稿一覧</a>
	</div>
</div>

<!-- 累計いいね数とお気に入りジャンルの表示 -->
<div class="user_inf2">
	<div class="total_good1">累積いいね数 <!--リクエストスコープで持ってくる？--></div>
	<div class="Favorite_Genre1">お気に入りジャンル</div>
</div>
<div class="user_inf2-2">
	<div class="total_good2">
		${total_good}いいね
	</div>
	<div class="Favorite_Genre2">
	<c:forEach var="Fgenre" items="${FGList}">
		${Fgenre}<br>
	</c:forEach>
	</div>
</div>
<!-- 編集ボタンと自分の最新投稿、自分の投稿一覧リンクの表示 -->
<div class="user_inf3">
	<!-- 編集ボタン -->
	<div class="do_change"><a href="/dokogacha/MypageChangeServlet">
			<img src="/dokogacha/img/button_edit.png" alt="編集"  ></a></div>
	<!-- 自分の最新投稿、自分の投稿一覧リンクの表示 -->
	<div class="review">
		<img src="/dokogacha/img/opcap_null.png" >
		<div class ="new_review">
			＃${review.ganre}<br>${review.price},${review.product_name}<br>${review.good}<br>
		</div>
		<div class ="review_list">
			<a href="/dokogacha/MyReviewListServlet"><br>自分の投稿一覧へ</a>
		</div>
	</div>
</div>
<!-- フッター -->
</div>
</body>
</html>